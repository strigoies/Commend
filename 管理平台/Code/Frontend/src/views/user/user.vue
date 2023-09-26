<style>
  /* .el-header {
    background-color: #d9caaf6f;
    color: rgb(49, 135, 182);
    text-align: center;
    line-height: 60px;
  } */
    .el-footer {
    background-color: #20252c;
    color: rgba(39, 27, 126, 0.132);
    text-align: center;
    line-height: 500px;
  }
  .el-aside {
    background-color: #fafbfc;
    color: rgb(255, 253, 253);
    text-align: center;
    line-height: 695px;
  }
  
  .el-main {
    background-color: #f7fafd;
    color: rgb(255, 253, 253);
    text-align: center;
    line-height: 120px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
<template>
  <div class="app-container">
    <!--表单value-format="yyyy-MM-dd"-->
    <el-form :inline="true" class="demo-form-inline">

      <el-form-item label="保险种类">
        <el-select
          v-model="insurance"
           clearable placeholder="选择要统计的保险种类" @change="$forceUpdate()">
           <el-option 
          v-for="item in options4"
          :key="item.value"
          :label="item.label"
          :value="item.label" />
        </el-select>
      </el-form-item>
      
      <el-button
        type="primary" icon="el-icon-search"
        @click="showChart();showChart1();showChart4();showChart5()">生成</el-button>
    </el-form>
    
    <el-container >

        <el-aside width="750px" height="100%">
            
            <el-main  height="50px">
                <div id="chart" class="chart" style="height:280px;width:100%" />
            </el-main>
            <el-main height="50px">
            <div id="map" class="chart" style="height:280px;width:100%"> </div>
            </el-main>
           
        </el-aside>
        <!-- <el-container direction=vertical>
            <el-header width="0px" height="'0px'">小额保险大数据可视化平台</el-header> 
            <el-main width="0px" height="50px">
                <div id="chart1" class="chart" style="height:300px;width:100%" @dblclick="revertMap" />
            </el-main>
            <el-main height="50px">
                <div id="chart2" class="chart" style="height:300px;width:100%"  />
            </el-main>
        </el-container> -->
        <el-aside width="750px">
            
            <el-main  height="50px">
                <div id="chart3" class="chart" style="height:280px;width:100%" />
            </el-main>
            <el-main  height="50px">
                <div id="chart4" class="chart" style="height:280px;width:100%" />
            </el-main>
           
        </el-aside>
        </el-container>
  </div>

</template>
<script>
import staApi from '@/api/user'
import * as echarts from 'echarts'
export default {
    data() {
        return {
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
          },
           {
            value:'全部',
            label:'全部'
          } ],
            //insurance:'',
            btnDisabled: false,
            xData:[],
            yData:[],
            pieData:[],
            num:0,
            dataList:[],
            dataprovice:[],
            mapData:{},
            insuranceInit:'全部'
        }
    },
    created() { //页面渲染之前执行
          this.showChart6();
           this.showChart7();
           this.showChart8();
           this.showChart9();
  },
  watch: {  //监听
  },
  methods:{
        showChart() {
            staApi.avatarEveryUserAvatar(this.insurance)
                .then(response => {
                     this.num=response.data.EveryUserAvatar.length
                     //pieData=EveryUserInjury
                     let xData = response.data.EveryUserAvatar.map(element => element.name)
                     let yData = response.data.EveryUserAvatar.map(element => element.value)
                     //console.log(Data)
                     //console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart()
                })
        },
         showChart1() {
                    staApi.ageEveryUserAge(this.insurance)
                        .then(response => {
                            console.log(this.insurance)
                            this.num=response.data.EveryUserAge.length
                            this.source=response.data.EveryUserAge
                            this.pieData=response.data.EveryUserAge
                            //console.log(this.source)
                        this.setChart1()
                        })
                },
            showChart5() {
                    staApi.genderEveryUserGender(this.insurance)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryUserGender.length)
                            this.num=response.data.EveryUserGender.length
                            
                            this.pieData=response.data.EveryUserGender
                            //调用下面生成图表的方法，改变值
                        this.setChart5()
                        })
                },
            showChart4() {
                    staApi.injuryEveryUserInjury(this.insurance)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryUserInjury.length)
                            this.num=response.data.EveryUserInjury.length
                            this.pieData=response.data.EveryUserInjury
                            //调用下面生成图表的方法，改变值
                        this.setChart4()
                        })
                },
            showChart6() {
            staApi.avatarEveryUserAvatar(this.insuranceInit)
                .then(response => {
                     this.num=response.data.EveryUserAvatar.length
                     //pieData=EveryUserInjury
                     let xData = response.data.EveryUserAvatar.map(element => element.name)
                     let yData = response.data.EveryUserAvatar.map(element => element.value)
                     //console.log(Data)
                     //console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart6()
                })
        },
         showChart7() {
                    staApi.ageEveryUserAge(this.insuranceInit)
                        .then(response => {
                            console.log(this.insurance)
                            this.num=response.data.EveryUserAge.length
                            this.source=response.data.EveryUserAge
                            this.pieData=response.data.EveryUserAge
                            //console.log(this.source)
                        this.setChart7()
                        })
                },
            showChart8() {
                    staApi.genderEveryUserGender(this.insuranceInit)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryUserGender.length)
                            this.num=response.data.EveryUserGender.length
                            
                            this.pieData=response.data.EveryUserGender
                            //调用下面生成图表的方法，改变值
                        this.setChart8()
                        })
                },
            showChart9() {
                    staApi.injuryEveryUserInjury(this.insuranceInit)
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryUserInjury.length)
                            this.num=response.data.EveryUserInjury.length
                            this.pieData=response.data.EveryUserInjury
                            //调用下面生成图表的方法，改变值
                        this.setChart9()
                        })
                },
            setChart5() {
            // 基于准备好的dom，初始化echarts实例
            this.chart5 = echarts.init(document.getElementById('chart4'),'light')
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎性别分布'
                },
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
                }]
            }

            this.chart5.setOption(option)
        },
            setChart4() {
            // 基于准备好的dom，初始化echarts实例
            this.chart4 = echarts.init(document.getElementById('chart3'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎伤情分布'
                },
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
                }]
            }

            this.chart4.setOption(option)
        },
        setChart1() {
            // 基于准备好的dom，初始化echarts实例
            this.chart1 = echarts.init(document.getElementById('map'))
             //console.log(this.chart)

            // 指定图表的配置项和数据
           var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎年龄分布'
                },
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
                }]
            }
            option && this.chart1.setOption(option)
        },
        setChart() {
            // 基于准备好的dom，初始化echarts实例
            this.chart = echarts.init(document.getElementById('chart'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: { 
                    text: '▎行业分布'
                },
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

            this.chart.setOption(option)
        },
        setChart6() {
            // 基于准备好的dom，初始化echarts实例
            this.chart6 = echarts.init(document.getElementById('chart4'),'light')
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎性别分布'
                },
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
                }]
            }

            this.chart6.setOption(option)
        },
            setChart7() {
            // 基于准备好的dom，初始化echarts实例
            this.chart7 = echarts.init(document.getElementById('chart3'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎伤情分布'
                },
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
                }]
            }

            this.chart7.setOption(option)
        },
        setChart8() {
            // 基于准备好的dom，初始化echarts实例
            this.chart8 = echarts.init(document.getElementById('map'))
             //console.log(this.chart)

            // 指定图表的配置项和数据
           var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎年龄分布'
                },
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
                }]
            }
            option && this.chart8.setOption(option)
        },
        setChart9() {
            // 基于准备好的dom，初始化echarts实例
            this.chart9 = echarts.init(document.getElementById('chart'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: { 
                    text: '▎行业分布'
                },
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

            this.chart9.setOption(option)
        }
         },

        
  }
</script>
