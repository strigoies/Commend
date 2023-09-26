<template>
  <div class="app-container">

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <!-- <el-form-item>
        <el-input v-model="teacherQuery.name" placeholder="姓名"/>
      </el-form-item> -->
      <el-form-item>
        <el-select v-model="teacherQuery.level" clearable placeholder="职业类别" >
          <el-option 
          v-for="item in options1"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="teacherQuery.avatar" clearable placeholder="所属行业" >
              <el-option 
          v-for="item in options2"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>


      <el-form-item>
        <el-select v-model="teacherQuery.province" clearable placeholder="省份">
           <el-option 
          v-for="item in options3"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>


      <el-form-item>
        <el-select v-model="teacherQuery.beInjured" clearable placeholder="是否出险">
          <el-option :value="0" label="未出险"/>
          <el-option :value="1" label="已出险"/>
        </el-select>
      </el-form-item>
     <el-form-item>
        <el-select v-model="teacherQuery.insurance" clearable placeholder="保险种类" >
          <el-option 
          v-for="item in options4"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
       <el-form-item>
        <el-select v-model="teacherQuery.insurancePlan" clearable placeholder="保险方案" >
          <el-option 
          v-for="item in options5"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
      <el-form-item>
        <el-select v-model="teacherQuery.injuredScene" clearable placeholder="出险场景" >
          <el-option 
          v-for="item in options6"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
      
      <el-form-item label="投保时间">
        <el-date-picker
          v-model="teacherQuery.begin"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="teacherQuery.end"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item label="出险时间">
        <el-date-picker
          v-model="teacherQuery.begininjury"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="teacherQuery.endinjury"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
        
      </el-form-item>

      <br>

      <el-button type="primary" icon="el-icon-search" @click="getList()">查询</el-button>
      <el-button type="default" @click="resetData()">清空</el-button>
      <el-button type="primary" icon="el-icon-edit" @click="go()">添加新用户</el-button>
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

      <el-table-column prop="level" label="职业类别" width="80">
        <!-- <template slot-scope="scope">
          {{ scope.row.level===1?'1类':'2类' }}
        </template> -->
      </el-table-column>

      <el-table-column prop="avatar" label="所属行业" width="80">
        <!-- <template slot-scope="scope">
          {{ scope.row.level===1?'制造业':'服务业' }}
        </template> -->
      </el-table-column>

      <el-table-column prop="province" label="所属省份" width="80" />
      <el-table-column prop="city" label="所属地市" width="80" />
      <el-table-column prop="country" label="所属区县" width="80" />
      <el-table-column prop="age" label="年龄" width="60" />

      <el-table-column prop="gender" label="性别" width="60">
          <!-- <template slot-scope="scope">
          {{ scope.row.beInjured===1?'男':'女' }}
        </template> -->
      </el-table-column>

      <el-table-column prop="beInjured" label="是否出险" width="80">
          <template slot-scope="scope">
          {{ scope.row.beInjured===1?'已出险':'未出险' }}
        </template>
      </el-table-column>
      <el-table-column prop="gmtCreate" label="投保时间" width="120"/>
      <el-table-column prop="gmtModified" label="出险时间" width="120"/>

      <el-table-column prop="injury" label="伤情" width="60">
          <!-- <template slot-scope="scope">
          {{ scope.row.beInjured===1?'轻伤':' ' }}
        </template> -->
      </el-table-column>
      <el-table-column prop="injuredScene" label="出险场景" width="90"/>
      <el-table-column prop="insurance" label="保险种类" width="90"/>
      <el-table-column prop="insurancePlan" label="保险方案" width="90"/>

     <el-table-column prop="intro" label="备注" width="150"/>
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeDataById(scope.row.id)">删除</el-button>
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
import teacher from '@/api/edu/teacher'

export default {
    //写核心代码位置
    // data:{
    // },
    data() { //定义变量和初始值
        return {
          options1:[{
            value:'1-3类',
            label:'1-3类'
          },
          {
            value:'4类',
            label:'4类'
          },
          {
            value:'5类',
            label:'5类'
          },
          {
            value:'6类',
            label:'6类'
          } ],
          options2:[{
            value:'一般职业',
            label:'一般职业'
          },
          {
            value:'农牧业',
            label:'农牧业'
          },
          {
            value:'出版广告业',
            label:'出版广告业'
          },
          {
            value:'制造、维修业',
            label:'制造、维修业'
          },
          {
            value:'娱乐业',
            label:'娱乐业'
          },
          {
            value:'建筑行业',
            label:'建筑行业'
          },
          {
            value:'文化教育',
            label:'文化教育'
          },
          {
            value:'木材加工业',
            label:'木材加工业'
          },
          {
            value:'渔业',
            label:'渔业'
          },
          {
            value:'水力燃气事业',
            label:'水力燃气事业'
          },
          {
            value:'道路运输业',
            label:'道路运输业'
          },
          {
            value:'金融、服务业',
            label:'金融、服务业'
          },
          {
            value:'零售批发业',
            label:'零售批发业'
          },
          {
            value:'餐饮旅游业',
            label:'餐饮旅游业'
          } ],
          options3:[{
            value:'安徽',
            label:'安徽'
          },
          {
            value:'陕西',
            label:'陕西'
          },
          {
            value:'澳门',
            label:'澳门'
          },
          {
            value:'北京',
            label:'北京'
          },
          {
            value:'重庆',
            label:'重庆'
          },
          {
            value:'福建',
            label:'福建'
          },
          {
            value:'甘肃',
            label:'甘肃'
          },
          {
            value:'广东',
            label:'广东'
          },
          {
            value:'广西',
            label:'广西'
          },
          {
            value:'海南',
            label:'海南'
          },
          {
            value:'河北',
            label:'河北'
          },
          {
            value:'黑龙江',
            label:'黑龙江'
          },
          {
            value:'河南',
            label:'河南'
          },
          {
            value:'湖北',
            label:'湖北'
          },
          {
            value:'湖南',
            label:'湖南'
          },
           {
            value:'江苏',
            label:'江苏'
          },
           {
            value:'江西',
            label:'江西'
          },
           {
            value:'吉林',
            label:'吉林'
          },
           {
            value:'辽宁',
            label:'辽宁'
          },
           {
            value:'内蒙古',
            label:'内蒙古'
          },
           {
            value:'宁夏',
            label:'宁夏'
          },
           {
            value:'青海',
            label:'青海'
          },
           {
            value:'山东',
            label:'山东'
          },
           {
            value:'上海',
            label:'上海'
          },
           {
            value:'山西',
            label:'山西'
          },
           {
            value:'台湾',
            label:'台湾'
          },
            {
            value:'天津',
            label:'天津'
          },
            {
            value:'香港',
            label:'香港'
          },
            {
            value:'新疆',
            label:'新疆'
          },
           {
            value:'西藏',
            label:'西藏'
          }, {
            value:'云南',
            label:'云南'
          },
           {
            value:'浙江',
            label:'浙江'
          }],
          options4:[{
            value:'天天保',
            label:'天天保'
          },
          {
            value:'雇主保',
            label:'雇主保'
          },
          {
            value:'全球保',
            label:'全球保'
          },
          {
            value:'灵工小保',
            label:'灵工小保'
          },
           {
            value:'即时保',
            label:'即时保'
          } ],
          options5:[{
            value:'方案一',
            label:'方案一'
          },
          {
            value:'方案二',
            label:'方案二'
          },
          {
            value:'方案三',
            label:'方案三'
          },
          {
            value:'方案四',
            label:'方案四'
          },
          {
            value:'方案五',
            label:'方案五'
          } ],
           options6:[{
            value:'生产事故',
            label:'生产事故'
          },
          {
            value:'交通事故',
            label:'交通事故'
          },
          {
            value:'非工意外',
            label:'非工意外'
          },
          {
            value:'突发疾病',
            label:'突发疾病'
          }],
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
            teacher.getTeacherListPage(this.page,this.limit,this.teacherQuery)
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
          this.$router.push({ path:'/teacher/save'})
        },
        //删除讲师的方法
        removeDataById(id) {
            this.$confirm('此操作将永久删除记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {  //点击确定，执行then方法
                //调用删除的方法
                teacher.deleteTeacherId(id)
                    .then(response =>{//删除成功
                    //提示信息
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    //回到列表页面
                    this.getList()
                })
            }) //点击取消，执行catch方法
        }
    }
}
</script>
