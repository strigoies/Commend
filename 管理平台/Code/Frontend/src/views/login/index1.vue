<template>
  <div class="login-container">
    <div class="login-box">
      <h2>登录系统</h2>
      <form>
        <div class="user-box">
          <input type="text" name="" required="" v-model="user.mobile">
          <label>手机号</label>
        </div>
        <div class="user-box">
          <input type="password" name="" required="" v-model="user.password">
          <label>密码</label>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a @click="handleSubmit">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          登录
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a @click="go()">注册 </a>
      </form>
    </div>
  </div>
</template>

<script>
import Router from 'vue-router'
import router from '@/router/index'
import axios from "axios";
import cookie from 'js-cookie'
import loginApi from '@/api/loginuser'
import {constantRoutes,asyncRoutes} from "@/router/index"
export default {
  name: "Login",
  data() {
    return {
        user:{
          mobile:'',
          password:''
        },
      username: '',
      password: '',
      msg: '',
      router:[]
    }
  },
  methods: {
     go(){
          this.$router.push({ path:'/login/register'})
        },
    open1() {
      this.$message({
        showClose: true,
        message: this.msg,
        type: 'warning'
      });
    },
    open2() {
      this.$message({
        showClose: true,
        message: this.msg,
        type: 'success'
      });
    },
    open3() {
      this.$message({
        showClose: true,
        message: this.msg,
        type: 'error'
      });
    },

    handleSubmit() {
        //第一步 调用接口进行登录，返回token字符串
        loginApi.submitLogin(this.user) 
           .then(response => {
             //第二步 获取token字符串放到cookie里面
             //第一个参数cookie名称，第二个参数值，第三个参数作用范围
             console.log(response.data.token)
             cookie.set('guli_token',response.data.token,{domain: 'localhost'})
             //window.location.href = "/"
              //第四步 调用接口 根据token获取用户信息，为了首页面显示
              loginApi.getLoginUserInfo()
                .then(response => {
                  this.loginInfo = response.data.userInfo
                  console.log(response.data.userInfo)
                  console.log(response.data.userInfo.sign)
                  //获取返回用户信息，放到cookie里面
                  cookie.set('guli_ucenter',this.loginInfo,{domain: 'localhost'})
                  if(response.data.userInfo.sign==="管理员"){
                      //this.routeruser=constantRouterMap.concat(asyncRouterMap)
                      this.$store.commit('login')
                      this.$router.addRoutes(constantRoutes.concat(asyncRoutes))
                      console.log('-------')
                       console.log(this.$store.state.isLogin)
                       console.log('-------')
                      //var array=constantRouterMap.concat(asyncRouterMap)
                      //console.log(this.routeruser)
                      //console.log(constantRouterMap)
                      this.$router.push('/')
                      //console.log(this.$router.addRoutes(this.routeruser))
                  }
                 // 跳转页面
                  else { window.location.href = "/";}
                })
           })
      },
      checkPhone (rule, value, callback) {
        //debugger
        if (!(/^1[34578]\d{9}$/.test(value))) {
          return callback(new Error('手机号码格式不正确'))
        }
        return callback()
      }
    }
  }

</script>

<style scoped>


   /* height: 100vh;
   background: linear-gradient(#141e30, #243b55);
   display: flex;
   justify-content: center;
   align-items: center;
   font-size: 16px;
   color: #03e9f4; */
  
    /* position: fixed;
  height: 100%;
  width: 100%;
  background: url("../../assets/images/22.png") no-repeat center;
  background-size: cover;  */
  /*background-image: url("../../assets/images/22.png") no-repeat center;
  /* background-size: cover;url(https://img-blog.csdnimg.cn/a7d3536782d34024914b76d3eafbe637.jpg); */
  /* background-repeat: no-repeat;
  background-size: 100%;
  background-position: 0px -50px; */ 


   /* height: 100vh;
   background: linear-gradient(#141e30, #243b55);
   display: flex;
   justify-content: center;
   align-items: center;
   font-size: 16px;
   color: #03e9f4; 
   position: fixed; */
  /* height: 100%;
  width: 100%;
  background: url("../../assets/images/22.png") no-repeat center;
  background-size: cover;  */

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: #BC8F8F;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}

.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4,
  0 0 25px #03e9f4,
  0 0 50px #03e9f4,
  0 0 100px #03e9f4;
}

.login-box a span {
  position: absolute;
  display: block;
}


.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%, 100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%, 100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%, 100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%, 100% {
    bottom: 100%;
  }
}

</style>
<style rel="stylesheet/scss" lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;
.login-container {
   position: fixed;
  height: 100%;
  width: 100%;
  background-color: $bg;
    position: absolute;
  height: 100%;
  width: 100%;
  background: url("../../assets/images/27.jpg");
  background-size: cover;
   }
  .login-form {
    position: absolute;
    left: 0;
    right: 0;
    width: 520px;
    max-width: 100%;
    padding: 35px 35px 15px 35px;
    margin: 120px auto;
  }
  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;
    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }
  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }
  .title {
    font-size: 26px;
    font-weight: 400;
    color: $light_gray;
    margin: 0px auto 40px auto;
    text-align: center;
    font-weight: bold;
    color: rgb(255, 255, 255);
  }
  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
  

</style>