<template>
  <div class="app-container">

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <!-- <el-form-item>
        <el-input v-model="teacherQuery.name" placeholder="姓名"/>
      </el-form-item> -->
      <el-form-item>
        <el-select v-model="level" clearable placeholder="职业类别" @change="$forceUpdate()">
          <el-option 
          v-for="item in options1"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="gender" clearable placeholder="性别" @change="$forceUpdate()">
              <el-option 
          v-for="item in options2"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
     <el-form-item>
        <el-select v-model="avatar" clearable placeholder="行业" @change="$forceUpdate()">
           <el-option 
          v-for="item in options3"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="be_injured" clearable placeholder="是否出险" @change="$forceUpdate()">
          <el-option :value="0" label="未出险"/>
          <el-option :value="1" label="已出险"/>
          <el-option :value="null" label="全部"/>
        </el-select>
      </el-form-item>
    
      <el-form-item>
        <el-select v-model="injury" clearable placeholder="伤情" @change="$forceUpdate()">
            <el-option 
          v-for="item in options4"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-select v-model="province" clearable placeholder="省份" @change="$forceUpdate()">
           <el-option 
          v-for="item in options5"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
     <el-form-item>
        <el-select v-model="injured_scene" clearable placeholder="出险场景" @change="$forceUpdate()" >
          <el-option 
          v-for="item in options6"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
   
     <el-form-item>
        <el-select v-model="insurance" clearable placeholder="保险种类" @change="$forceUpdate()">
          <el-option 
          v-for="item in options7"
          :key="item.value"
          :label="item.label"
          :value="item.value" />   
        </el-select>
      </el-form-item>
       <el-form-item>
        <el-select v-model="category" clearable placeholder="统计属性" @change="$forceUpdate()">
          <el-option 
          v-for="item in options8"
          :key="item.value"
          :label="item.label"
          :value="item.value" /> 
          </el-select>
      </el-form-item>
      <el-button type="primary"  round @click="showChart5()">饼状图</el-button>
      <el-button type="primary"  round @click="showChart4()">柱状图</el-button>
      <el-button type="primary"  round @click="showChart3()">折线图</el-button>
    </el-form>
<div id="chart" class="chart" style="height:500px;width:1400px" />
          
  </div>

</template>
<script>
import staApi from '@/api/makecharts'
import * as echarts from 'echarts'
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
          },
           {
            value:'null',
            label:'全部'
          } ],
            options2:[{
            value:'男',
            label:'男'
          },
          {
            value:'女',
            label:'女'
          },
           {
            value:'null',
            label:'全部'
          }],
          options3:[{
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
          },
           {
            value:'null',
            label:'全部'
          } ],
          options4:[{
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
          },
           {
            value:'null',
            label:'全部'
          }
          ],
          options5:[{
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
          },
           {
            value:'null',
            label:'全部'
          }],
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
          },
           {
            value:'null',
            label:'全部'
          }],
            options7:[{
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
          },
           {
            value:'null',
            label:'全部'
          }],
               options8:[{
            value:'age',
            label:'年龄'
          },
          {
            value:'avatar',
            label:'行业'
          },
          {
            value:'province',
            label:'省份'
          },
          {
            value:'gender',
            label:'性别'
          },
           {
            value:'career',
            label:'职业'
          },
           {
            value:'level',
            label:'职业类别'
          },
           {
            value:'insurance',
            label:'保险种类'
          },
           {
            value:'insurance_plan',
            label:'保险方案'
          },
           {
            value:'be_injured',
            label:'是否出险'
          }],
            //insurance:'',
            btnDisabled: false,
            xData:[],
            yData:[],
            pieData:[],
            num:0,
            dataList:[],
            dataprovice:[],
            mapData:{},
            level:'',gender:'',avatar:'',be_injured:'',injury:'',province:'',injured_scene:'',insurance:'',category:'',
            levelInit:'null',genderInit:'null',avatarInit:'null',be_injuredInit:'null',injuryInit:'null',provinceInit:'null',injured_sceneInit:'null',insuranceInit:'null',categoryInit:'avatar'
        }
    },
    created() { //页面渲染之前执行
         this.showChart6(); 
         
  },
  watch: {  //监听
  },
  methods:{
            showChart6() {
                    staApi.createMakeCharts(this.levelInit,this.genderInit,this.avatarInit,this.be_injuredInit,this.injuryInit,this.provinceInit,this.injured_sceneInit,this.insuranceInit,this.categoryInit)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.MadeChart.length)
                            this.num=response.data.MadeChart.length
                            let xData = response.data.MadeChart.map(element => element.name)
                           let yData = response.data.MadeChart.map(element => element.value)
                            this.xData=xData
                            this.yData=yData
                            //调用下面生成图表的方法，改变值
                        this.setChart6()
                        })
                },
            showChart5() {
                    staApi.createMakeCharts(this.level,this.gender,this.avatar,this.be_injured,this.injury,this.province,this.injured_scene,this.insurance,this.category)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.MadeChart.length)
                            this.num=response.data.MadeChart.length
                            
                            this.pieData=response.data.MadeChart
                            //调用下面生成图表的方法，改变值
                        this.setChart5()
                        })
                },
            showChart4() {
            staApi.createMakeCharts(this.level,this.gender,this.avatar,this.be_injured,this.injury,this.province,this.injured_scene,this.insurance,this.category)
                        .then(response => {
                     this.num=response.data.MadeChart.length
                     //pieData=EveryUserInjury
                     let xData = response.data.MadeChart.map(element => element.name)
                     let yData = response.data.MadeChart.map(element => element.value)
                     //console.log(Data)
                     console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart4()
                })
        },
        showChart3() {
                    staApi.createMakeCharts(this.level,this.gender,this.avatar,this.be_injured,this.injury,this.province,this.injured_scene,this.insurance,this.category)
                        .then(response => {
                            let xData = response.data.MadeChart.map(element => element.name)
                            let yData = response.data.MadeChart.map(element => element.value)
                            console.log(xData)
                            console.log(yData)
                            this.xData=xData
                            this.yData=yData
                            //调用下面生成图表的方法，改变值
                        this.setChart3()
                        })
                },
            setChart6() {
            // 基于准备好的dom，初始化echarts实例
            this.chart6 = echarts.init(document.getElementById('chart'))
            var option = {
                tooltip: {
                    trigger: 'axis'
                },
                // x轴是类目轴（离散数据）,必须通过data设置类目数据
                xAxis: {
                    type: 'category',
                    data: this.xData,
                    axisLabel: { interval: 0,
                                 rotate: 60,
                                 fontSize:10,
                                color: "rgba(40, 37, 37, 1)",
                                 fontWeight: "bolder" }
                },
                // y轴是数据轴（连续数据）
                yAxis: {
                    type: 'value'
                },
                // 系列列表。每个系列通过 type 决定自己的图表类型
                series: [{
                    // 系列中的数据内容数组
                    data: this.yData,
                    // 折线图
                    type: 'bar'
                }]
            }

            this.chart6.setOption(option)
        },
            setChart5() {
            // 基于准备好的dom，初始化echarts实例
            this.chart5 = echarts.init(document.getElementById('chart'),'light')
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                //系列列表。每个系列通过 type 决定自己的图表类型
                series: [{
                    // 系列中的数据内容数组
                    data:this.pieData,
                    // 折线图
                    type: 'pie',
                    label:{
                        show:true
                    },
                    center:["50%",'50%']
                }]
            }

            this.chart5.setOption(option,true)
        },
        setChart4() {
            // 基于准备好的dom，初始化echarts实例
            this.chart4 = echarts.init(document.getElementById('chart'))
            var option = {
                tooltip: {
                    trigger: 'axis'
                },
                // x轴是类目轴（离散数据）,必须通过data设置类目数据
                xAxis: {
                    type: 'category',
                    data: this.xData,
                    axisLabel: { interval: 0,
                                 rotate: 60,
                                 fontSize:10,
                                color: "rgba(40, 37, 37, 1)",
                                 fontWeight: "bolder" }
                },
                // y轴是数据轴（连续数据）
                yAxis: {
                    type: 'value'
                },
                // 系列列表。每个系列通过 type 决定自己的图表类型
                series: [{
                    // 系列中的数据内容数组
                    data: this.yData,
                    // 折线图
                    type: 'bar'
                }]
            }

            this.chart4.setOption(option,true)
        },
         setChart3() {
            // 基于准备好的dom，初始化echarts实例
            this.chart3 = echarts.init(document.getElementById('chart'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                
                tooltip: {
                    trigger: 'axis'
                },
                // x轴是类目轴（离散数据）,必须通过data设置类目数据
                xAxis: {
                    type: 'category',
                    data: this.xData
                },
                // y轴是数据轴（连续数据）
                yAxis: {
                    type: 'value'
                },
                // 系列列表。每个系列通过 type 决定自己的图表类型
                series: [{
                    // 系列中的数据内容数组
                    data: this.yData,
                    // 折线图
                    type: 'line',
                    barWidth:30,
                    label:{
                        show:true,
                        position:'top',
                        textStyle: {
                        color: 'black'
                    }
                    },
                    itemStyle: {
                        barBorderRadius:[0,0,0,0],
                        }
                }]
            }

            this.chart3.setOption(option,true)
        },         
  }}
</script>