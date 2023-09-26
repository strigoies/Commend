<template>
  <div class="app-container">
     <el-form label-width="80px" label-height="30px">
      <!-- <el-form-item label="姓名" controls-position="right">
        <el-input v-model="teacher.name" />
      </el-form-item> -->
      <el-form-item label="性别">
        <el-select v-model="teacher.gender" style="width:100px" size="medium" clearable placeholder="请选择">
          <el-option 
          v-for="item in options7"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
        </el-select>
      </el-form-item>
      <el-form-item label="年龄" >
        <el-input-number v-model="teacher.age" controls-position="right" min="0"/>
      </el-form-item>
      <el-form-item label="工种名称">
        <el-input v-model="teacher.career" style="width:100px" size="medium" />
          <!-- <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/> -->
        <!-- </el-select> -->
      </el-form-item>
      <el-form-item label="所属行业">
        <el-select v-model="teacher.avatar" style="width:100px" size="medium" clearable placeholder="请选择" >
          <!-- <el-option :value="1" label="制造业"/>
          <el-option :value="2" label="服务业"/> -->
           <el-option 
          v-for="item in options2"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
        </el-select>
      </el-form-item>
      <el-form-item label="职业类别">
        <el-select v-model="teacher.level" clearable placeholder="请选择"> 
          <el-option 
          v-for="item in options1"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
     
      </el-form-item>
      <el-form-item label="所属省份">
       <el-select v-model="teacher.province" style="width:100px" size="medium" clearable placeholder="请选择">
          <!-- <el-option :value="1" label="山东省"/>
          <el-option :value="2" label="北京市"/> -->
        <el-option 
          v-for="item in options3"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
      <el-form-item label="所属地市">
        <el-input v-model="teacher.city"  style="width:100px" size="medium"/>
          <!-- <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/> -->
        
      </el-form-item>
      <el-form-item label="是否出险">
        <el-select v-model="teacher.beInjured" clearable placeholder="请选择">
          <el-option :value="0" label="未出险"/>
          <el-option :value="1" label="已出险"/>
        </el-select>
      </el-form-item>
      <el-form-item label="伤情">
        <el-select v-model="teacher.injury" style="width:100px" size="medium" clearable placeholder="请选择">
          <el-option 
          v-for="item in options8"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
        </el-select>
          <!-- <el-option :value="1" label="轻伤"/>
          <el-option :value="2" label="重伤"/> -->
        
      </el-form-item>
      <!--<el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>-->
      <el-form-item label="出险场景" controls-position="right">
        <el-select v-model="teacher.injuredScene" style="width:100px" size="medium" clearable placeholder="请选择">
          <el-option 
          v-for="item in options6"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
      <el-form-item label="保险种类" controls-position="right">
        <el-select v-model="teacher.insurance" style="width:100px" size="medium" clearable placeholder="请选择">
          <el-option 
          v-for="item in options4"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
       <el-form-item label="保险方案" controls-position="right">
        <el-select v-model="teacher.insurancePlan" style="width:100px" size="medium" clearable placeholder="请选择">
          <el-option 
          v-for="item in options5"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像：TODO -->

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>
<script>
import teacherApi from '@/api/edu/teacher'
export default {
  data() {
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
          options7:[{
            value:'男',
            label:'男'
          },
          {
            value:'女',
            label:'女'
          }
          ],
            options8:[{
            value:'伤残/可能伤残',
            label:'伤残/可能伤残'
          },
          {
            value:'住院',
            label:'住院'
          },
          {
            value:'放弃/超时',
            label:'放弃/超时'
          },
          {
            value:'身故',
            label:'身故'
          },
          {
            value:'轻微',
            label:'轻微'
          }
          ],
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
      if(this.$route.params && this.$route.params.id) {
          //从路径获取id值
          const id = this.$route.params.id
          //调用根据id查询的方法
          this.getInfo(id)
      } else { //路径没有id值，做添加
        //清空表单
        this.teacher = {}
      }
    },
    //根据讲师id查询的方法
    getInfo(id) {
      teacherApi.getTeacherInfo(id)
        .then(response => {
          this.teacher = response.data.teacher
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
      teacherApi.updateTeacherInfo(this.teacher)
        .then(response => {
          //提示信息
          this.$message({
              type: 'success',
              message: '修改成功!'
          });
          //回到列表页面 路由跳转
          this.$router.push({path:'/teacher/table'})
        })
    },
    //添加讲师的方法
    saveTeacher() {
      teacherApi.addTeacher(this.teacher)
        .then(response => {//添加成功
          //提示信息
          this.$message({
              type: 'success',
              message: '添加成功!'
          });
          //回到列表页面 路由跳转
          this.$router.push({path:'/teacher/table'})
        })
    }

  }
}
</script>
