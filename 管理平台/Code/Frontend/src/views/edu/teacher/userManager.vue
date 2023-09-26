<template>
  <div class="app-container">

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <!-- <el-form-item>
        <el-input v-model="teacherQuery.name" placeholder="姓名"/>
      </el-form-item> -->
      <el-form-item>
        <el-input v-model="teacherQuery.mobile" clearable placeholder="手机号" />  
      
      </el-form-item>
      <el-form-item>
        <el-input v-model="teacherQuery.avatar" clearable placeholder="所属行业" >
              <!-- <el-option 
          v-for="item in options2"
          :key="item.value"
          :label="item.label"
          :value="item.value" />    -->
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-select v-model="teacherQuery.sex" clearable placeholder="性别">
          <el-option :value="1" label="男"/>
          <el-option :value="2" label="女"/>
        </el-select>
      </el-form-item>
        <el-form-item>
        <el-input v-model="teacherQuery.sign" clearable placeholder="角色" >
          <!-- <el-option :value="管理员" label="管理员"/>
          <el-option :value="普通用户" label="普通用户"/> -->
        </el-input>
      </el-form-item>
      <br>
      <el-button type="primary" icon="el-icon-search" @click="getList()">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>
    <br>
    <!-- 表格 -->
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <!-- <el-table-column prop="name" label="姓名" width="80" /> -->

      <el-table-column prop="nickname" label="用户名" width="140">
        <!-- <template slot-scope="scope">
          {{ scope.row.level===1?'1类':'2类' }}
        </template> -->
      </el-table-column>

      <el-table-column prop="mobile" label="手机号" width="140">
        <!-- <template slot-scope="scope">
          {{ scope.row.level===1?'制造业':'服务业' }}
        </template> -->
      </el-table-column>

      <el-table-column prop="password" label="密码" width="150" />
      <el-table-column prop="sex" label="性别" width="80" >
          <template slot-scope="scope">
          {{ scope.row.sex===1?'男':'女' }}
        </template>
        </el-table-column>
      <el-table-column prop="age" label="年龄" width="60" />
        <el-table-column prop="avatar" label="行业" width="150" />
      <el-table-column prop="sign" label="用户角色" width="120" />

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/userManager/edituser/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <!-- //<el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>

  <!-- 分页 -->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getList"
    />

  </div>
</template>
<script>
//引入调用teacher.js文件
import teacher from '@/api/userManager'

export default {
    //写核心代码位置
    // data:{
    // },
    data() { //定义变量和初始值
        return {
          list:null,//查询之后接口返回集合
          page:1,//当前页
          limit:10,//每页记录数
          total:0,//总记录数
          teacherQuery:{} ,//条件封装对象
        }
    },
    created() { //页面渲染之前执行，一般调用methods定义的方法
        //调用
        this.getList() 
    },
    methods:{  //创建具体的方法，调用teacher.js定义的方法
        //讲师列表的方法
        getList(page=1) {
            this.page = page
            teacher.getUserListPage(this.page,this.limit,this.teacherQuery)
                .then(response =>{//请求成功
                    //response接口返回的数据
                    //console.log(response)
                    this.list = response.data.rows
                    this.total = response.data.total
                    console.log(this.list)   
                    console.log(this.total)
                    console.log(this.teacherQuery)
                }) 
        },
        resetData() {//清空的方法
            //表单输入项数据清空
            this.teacherQuery = {}
            //查询所有讲师数据
            this.getList()
        },
        go(){
          this.$router.push({ path:'/teacher/saveUser'})
        }
    }
}
</script>
