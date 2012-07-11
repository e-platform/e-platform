<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <body>
欢迎${userName}登陆
<@s.form action="login">
 <@s.textfield name="username" label="username"/>
 <@s.submit value="login" />
</@s.form>
欢迎<@s.property value="userName"/>登录!

    </body>
</html>