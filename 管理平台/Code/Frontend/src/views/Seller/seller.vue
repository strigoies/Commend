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
    <!--<div class="chart-container">-->
        <!--<div id="chart" class="chart" style="height:300px;width:30%" />
        <div id="map" class="chart" style="height:300px;width:30%"> </div>-->

        <el-container >
        <el-aside width="750px" height="100%">
            <el-main  height="50px">
                <div id="chart" class="chart" style="height:300px;width:100%" />
            </el-main>
            <el-main height="50px">
            <div id="map" class="chart" style="height:300px;width:100%"> </div>
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
                <div id="chart3" class="chart" style="height:300px;width:100%" />
            </el-main>
            <el-main  height="50px">
                <div id="chart4" class="chart" style="height:300px;width:100%" />
            </el-main>
        </el-aside>
        </el-container>
</template>
<script>
//import 'echarts/map/js/china.js' 
import staApi from '@/api/seller'
import * as echarts from 'echarts'
export default {
  data() {
    return {
            searchObj:{},
            btnDisabled:false,
            xData:[],
            yData:[],
            pieData:[],
            num:0,
            dataList:[],
            dataprovice:[],
            mapData:{},
            source:[]
            
    }
  },
  created() { //页面渲染之前执行
    this.showChart(),
    this.showChart1(), 
    this.showChart4(),
    this.showChart5()
  },
  watch: {  //监听
  },
  methods:{
        showChart() {
            staApi.insuranceEveryInsurance()
                .then(response => {
                     //console.log(response)
                     //console.log(response.data.EveryAvatarInjury.length)
                     this.num=response.data.EveryInsurance.length
                     let xData = response.data.EveryInsurance.map(element => element.name)
                     let yData = response.data.EveryInsurance.map(element => element.value)
                     let Data = response.data.EveryInsurance.map(element => element.EveryInsurance)
                     console.log(Data)
                     //console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart()
                })
        },
         showChart1() {
                    staApi.insuranceplanEveryInsurancePlan()
                        .then(response => {
                            console.log(response)
                            this.num=response.data.EveryInsurancePlan.length
                            this.source=response.data.EveryInsurancePlan
                            console.log(this.source)
                            let xData = response.data.EveryInsurancePlan.map(element => element.name)
                            let yData = response.data.EveryInsurancePlan.map(element => element.value)
                            this.xData=xData
                            this.yData=yData
                            // let girl = xData[0]
                            // let boy = xData[1]
                            // let girlnum = yData[0]
                            // let boynum = yData[1]
                            // this.pieData = response.data.EveryMonthInjury
                            // console.log(boy)
                            // console.log(this.pieData)
                            //调用下面生成图表的方法，改变值
                        this.setChart1()
                        })
                },
            showChart5() {
                    staApi.avatarEveryAvatarBuyInsurance()
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryAvatarBuyInsurance.length)
                            this.num=response.data.EveryAvatarBuyInsurance.length
                            let xData = response.data.EveryAvatarBuyInsurance.map(element => element.name)
                            let yData = response.data.EveryAvatarBuyInsurance.map(element => element.value)
                            console.log(xData)
                            console.log(yData)
                            this.xData=xData
                            this.yData=yData
                            //调用下面生成图表的方法，改变值
                        this.setChart5()
                        })
                },
            showChart4() {
                    staApi.monthEveryMonthBuyInsurance()
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryMonthBuyInsurance.length)
                            this.num=response.data.EveryMonthBuyInsurance.length
                            let xData = response.data.EveryMonthBuyInsurance.map(element => element.name)
                            let yData = response.data.EveryMonthBuyInsurance.map(element => element.value)
                            console.log(xData)
                            console.log(yData)
                            this.xData=xData
                            this.yData=yData
                            //调用下面生成图表的方法，改变值
                        this.setChart4()
                        })
                },
            setChart5() {
            // 基于准备好的dom，初始化echarts实例
            this.chart5 = echarts.init(document.getElementById('chart4'),'light')
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                
                            title: {
                text: '▎各行业购买保险数量',
                
                },
                grid: {
                top: '20%',
                left: '3%',
                right: '6%',
                bottom: '3%',
                containLabel: true // 距离是包含坐标轴上的文字
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

            this.chart5.setOption(option)
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart5.resize();
        }
        },
            setChart4() {
            // 基于准备好的dom，初始化echarts实例
            this.chart4 = echarts.init(document.getElementById('chart3'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '▎各月销售保险数量'
                },
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                top: '20%',
                left: '3%',
                right: '6%',
                bottom: '3%',
                containLabel: true // 距离是包含坐标轴上的文字
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

            this.chart4.setOption(option)
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart4.resize();
        }
        },
        setChart1() {
            // 基于准备好的dom，初始化echarts实例
            this.chart1 = echarts.init(document.getElementById('map'))
             //console.log(this.chart)

            // 指定图表的配置项和数据
            var option
            option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎保险种类各方案销售占比'
                },
                 tooltip: {
                    trigger: 'item'
                },
                dataset: [
                {
                source:this.source
                },
                {
                transform: {
                    type: 'filter',
                    config: { dimension: 'insurance', value: '天天保' }
                }
                },
                {
                transform: {
                    type: 'filter',
                    config: { dimension: 'insurance', value: '全球保' }
                }
                },
                {
                transform: {
                    type: 'filter',
                    config: { dimension: 'insurance', value: '即时保' }
                }
                },
                {
                transform: {
                    type: 'filter',
                    config: { dimension: 'insurance', value:  '雇主保' }
                }
                },
                {
                transform: {
                    type: 'filter',
                    config: { dimension: 'insurance', value:  '灵工小保' }
                }
                }
            ],
            series: [
                {
                type: 'pie',
                name:'天天保',
                radius: 50,
                center: ['20%', '20%'],
                datasetIndex: 1
                },
                {
                type: 'pie',
                name:'全球保',
                radius: 50,
                center: ['50%', '30%'],
                datasetIndex: 2
                },
                {
                type: 'pie',
                name:'即时保',
                radius: 50,
                center: ['50%', '30%'],
                datasetIndex: 3
                },
                {
                type: 'pie',
                name:'雇主保',
                radius: 50,
                center: ['37%', '80%'],
                datasetIndex: 4
                },
                {
                type: 'pie',
                name:'灵工小保',
                radius: 50,
                center: ['65%', '80%'],
                datasetIndex: 5
                }
            ],
            // Optional. Only for responsive layout:
            media: [
                {
                query: { minAspectRatio: 1 },
                option: {
                    series: [
                    { center: ['20%', '40%'] },
                    { center: ['50%', '40%'] },
                    { center: ['80%', '40%'] }
                    ]
                }
                },
                {
                option: {
                    series: [
                    { center: ['50%', '25%'] },
                    { center: ['50%', '50%'] },
                    { center: ['50%', '75%'] }
                    ]
                }
                }
            ]
            }
            option && this.chart1.setOption(option)
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart1.resize();
        }
        },
        setChart() {
            // 基于准备好的dom，初始化echarts实例
            this.chart = echarts.init(document.getElementById('chart'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: { 
                    text: '▎保险种类销售数量'
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
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            //resizeWorldMapContainer();//重置容器高宽
            this.chart.resize();
        }
            this.chart.setOption(option)
        }
         }, 
  }
</script>
