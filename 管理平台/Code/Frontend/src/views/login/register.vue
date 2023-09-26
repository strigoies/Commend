<template>
  <div class="login-wrap">
    <el-form class="login-container">
      <h1 class="title">用户注册</h1>
<!--      
      <el-form-item label="">
          <el-select type="text" v-model="params.sex" clearable placeholder="性别">
          <el-option :value="1" label="男"/>
          <el-option :value="2" label="女"/>
        </el-select>
      </el-form-item>
      <el-form-item label="">
        <el-input type="text" placeholder="年龄" v-model="params.age" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input type="text" placeholder="行业" v-model="params.avatar" autocomplete="off"></el-input>
      </el-form-item> -->
      <el-form-item label="">
        <el-input type="text" placeholder="手机号" v-model="params.mobile" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input type="text" placeholder="验证码" v-model="params.nickname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input type="password" placeholder="用户密码" v-model="params.password" autocomplete="off"></el-input>
      
        <el-button type="success" @click="doRegister()" style="width: 30%;" >用户注册</el-button>
        <el-button type="primary" @click="gotoLogin()"    style="width: 30%;" >返回登陆</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import registerApi from '@/api/register'
/*  import axios from 'axios'
  import qs from 'qs' */
  export default{
      data:function(){
        return{
        params:{
            mobile:'',
            nickname:'',
            password:'',
            age:'',
            avatar:'',
            sex:''
        },
          username:null,
          password:null,
          password1:null
        }
      },
      methods:{
        gotoLogin:function(){
           this.$router.push({ path:'/login/'})
        },
        doLogin:function(){
          let params={
            username:this.username,
            password:this.password,
            methodName:'userLogin'
          };
          console.log(params);

          this.axios.get(this.axios.urls.SYSTEM_USER_DOLOGIN,{
            params:params
          }).then(resp => {
              console.log(resp.data);
          }).catch(resp=>{});
    
          /* this.axios.post(this.axios.urls.SYSTEM_USER_DOLOGIN
          ,params).then(resp => {
              console.log(resp.data);
          }).catch(resp=>{}); */
        },
        doRegister(){
           registerApi.registerMember(this.params)
           .then(response=>{
               this.$message({
                   type:'success',
                   messeage:"注册成功",
                   color:'#505458'
               })
              
              this.$router.push({path:'/login/'})
           }) 
        }
      }
  }
</script>
//scoped="scoped" 表示样式仅仅规范当前VUE
<style scoped="scoped">
  .login-wrap {
  		box-sizing: border-box;
  		width: 100%;
  		height: 100%;
  		padding-top: 10%;
  		background-image: url("../../assets/images/27.jpg");
  		/* background-color: #112346; */
  		background-repeat: no-repeat;
  		background-position: center right;
  		background-size: 100%;
  	}

  	.login-container {
  		/* border-radius: 10px;
      position: center;
  		margin: 0px auto 0px auto;
  		width: 350px;
  		padding: 30px 35px 15px 35px;
  		background: #fff;
  		border: 1px solid #eaeaea;
  		text-align: left;
  		box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1); */
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

  	.title {
  		margin: 0px auto 40px auto;
  		text-align: center;
  		color: #505458;
  	}
</style>

