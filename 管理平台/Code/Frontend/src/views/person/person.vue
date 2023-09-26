<template>
  <div class="app-container">
     <el-form label-width="80px" label-height="30px">
      <!-- <el-form-item label="姓名" controls-position="right">
        <el-input v-model="teacher.name" />
      </el-form-item> -->
      <el-form-item label="用户名">
        <el-input v-model="teacher.nickname" style="width:100px" size="medium" > 
        </el-input>
        </el-form-item>
         <el-form-item label="手机号">
        <el-input v-model="teacher.mobile" controls-position="right" style="width:15%" > 
        </el-input>
        </el-form-item>
        <el-form-item label="密码">
        <el-input v-model="teacher.password" style="width:15%" />
          <!-- <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/> -->
        <!-- </el-select> -->
      </el-form-item>
      
       <el-form-item label="性别">
        <el-select v-model="teacher.sex" style="width:100px" size="medium" > 
        <el-option :value="1" label="男"/>
          <el-option :value="2" label="女"/>
        </el-select>
        </el-form-item>
      <el-form-item label="年龄" >
        <el-input v-model="teacher.age" style="width:100px" size="medium"/>
      </el-form-item>
      <!-- <el-form-item label="用户角色">
        <el-input v-model="teacher.sign" style="width:100px" size="medium" />
      </el-form-item> -->
      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>
<script>
import userApi from '@/api/userManager'
import loginApi from '@/api/loginuser'
export default {
  data() {
    return {
      teacher:{},
      saveBtnDisabled:false  // 保存按钮是否禁用,
    }
  },
  created() { //页面渲染之前执行
    this.init()
  },
  watch: {  //监听
    $route(to, from) { //路由变化方式，路由发生变化，方法就会执行
      this.init()
    }
  },
  methods:{

    init() {
      //判断路径有id值,做修改
     
          //调用根据id查询的方法
          this.getInfo()
     
    },
    //根据讲师id查询的方法
    getInfo() {
       loginApi.getLoginUserInfo()
                .then(response => {
                  this.loginInfo = response.data.userInfo
                  console.log(response.data.userInfo)
                  console.log(response.data.userInfo.id)
                  this.id=response.data.userInfo.id
                  this.teacher = response.data.userInfo
                  console.log(this.teacher)
                  //获取返回用户信息，放到cookie里面
                 // 跳转页面
                  //window.location.href = "/";
                })
    },
    saveOrUpdate() {
      //判断修改还是添加
      //根据teacher是否有id
      if(!this.teacher.id) {
        //添加
        this.saveTeacher()
      } else {
        //修改
        this.updateTeacher()
      }
    },
    //修改讲师的方法
    updateTeacher() {
      userApi.updateTeacherInfo(this.teacher)
        .then(response => {
          //提示信息
          this.$message({
              type: 'success',
              message: '修改成功!'
          });
          //回到列表页面 路由跳转
          this.$router.push({path:'/person/person'})
        })
    },

  }
}
</script>
