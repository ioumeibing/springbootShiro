package com.how2java.springboot.web;
import com.how2java.springboot.helper.PasswordHelper;
import com.how2java.springboot.helper.Response;
import com.how2java.springboot.helper.ResponseResult;
import com.how2java.springboot.pojo.*;
import com.how2java.springboot.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@RestController
public class PersonController {

   @Autowired PersonService personService;
   @Autowired RoleService roleService;
   @Autowired DepartmentService departmentService;
   @Autowired userRoleService userRoleService;
   @Autowired userDepartmentService userDepartmentService;

   static int personCount=0;
    @GetMapping("/persons")
    public ResponseResult<List<Person>> list() throws Exception{
       log.info("获取数据");
       List<Person> persons=personService.GetAll();
       personCount=persons.size();
       return Response.makeOkRsp(persons);

   }

    /*@PathVariable 注解通过变量名匹配到 URI 模板中相对应的变量*/
   @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
       log.info("删除");
       personService.delete(id);
       return "success";
   }

   @PostMapping("/persons")
    public ResponseResult<Object> add(@RequestBody Person p)throws Exception{
       int uid=personCount;
       Set<Role> roles= p.getRoleList();
       roles.forEach(role -> {
           personService.addUserRole(uid+1,role.getId());
       });

       List<Department> deps =p.getDepartments();
       deps.forEach(department -> {
           personService.addUserDept(uid+1,department.getDid());
       });
       /*盐加密*/
       String salt =PasswordHelper.createSalt();
       String password = PasswordHelper.createCredentials(p.getPassword(),salt);
       p.setPassword(password);
       p.setSalt(salt);
       return Response.makeOkRsp(personService.add(p));
   }

   @PutMapping("/persons/{id}")
    public ResponseResult<Object> update(@RequestBody Person p)throws Exception{

        List<userRole> userRoles =userRoleService.getUrByUid(p.getId());
        Set<Role> roles =p.getRoleList();
        if (userRoles.size()==0){
            userRole addUr = new userRole();
            addUr.setUid(p.getId());
            if (roles.size() !=0 && roles.size()==1){
                roles.forEach(role -> {
                    addUr.setRid(role.getId());
                });
                userRoleService.adduserRole(addUr);
            }
        }
        else{
            userRoles.forEach(ur -> {
                if (roles.size()!=0){
                    roles.forEach(role -> {
                        if (ur.getRid() !=role.getId())
                        {
                            userRole urs =new userRole();
                            urs.setUrid(ur.getUrid());
                            urs.setUid(ur.getUid());
                            urs.setRid(role.getId());
                            userRoleService.updateUserRole(urs);
                        }
                    });
                }
            });
        }

        List<userDepartment> userDepartments = userDepartmentService.getUdByUid(p.getId());

        List<Department> depts=p.getDepartments();

        userDepartments.forEach(ud -> {
            depts.forEach(dept -> {
                //选择的部门和原来的部门不一样
                if (ud.getDid() != dept.getDid()) {

                    userDepartment uds = new userDepartment();
                    uds.setId(ud.getId());
                    uds.setUid(ud.getUid());
                    uds.setDid(dept.getDid());
                    userDepartmentService.updateUserDepartment(uds);
                }
            });
        });

      return Response.makeOkRsp(personService.update(p));
   }

    @PostMapping ("/foreLogin")
    public ResponseResult<Object> Login(@RequestBody Person person, HttpSession session){

            String userName = person.getUserName();
            userName = HtmlUtils.htmlEscape(userName);
            /*Person p = personService.getUserByName(userName);*/
            String password =person.getPassword().trim();
           /*将用户密码存储在token中*/
           UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
           /*Subject是Shiro的主体，主要作用就是存储用户信息。我们登录和注销都需要用Subject,否则验证将不生效*/
           Subject subject = SecurityUtils.getSubject();
           try{
               /*一定要先登录，否则用户信息将为空。最后就是将用户存储在session中*/
               subject.login(token);
               Person per =(Person) subject.getPrincipal();
               session.setAttribute("per",per);
           }

           catch (Exception e){
               System.out.println(e);
               return Response.makeErrRsp("用户账号或密码不正确");
           }
           return Response.makeOkRsp();
   }


    @GetMapping("/depts")
    public ResponseResult<List<Department>> deptList()
    {
        return Response.makeOkRsp(departmentService.getByAllDept());
    }

}
