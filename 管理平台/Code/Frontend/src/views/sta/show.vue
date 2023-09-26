<style>
  /* .el-header {
    background-color: #d9caaf6f;
    color: rgb(49, 135, 182);
    text-align: center;
    line-height: 60px;
  } */
    .el-footer {
    background-color: #f7fafd;
    color: rgb(246, 246, 250);
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
        <el-aside width="450px" height="100%">
            <el-main height="50px">
                <div id="chart" class="chart" style="height:300px;width:100%" />
            </el-main>
            <el-main height="50px">
            <div id="map" class="chart" style="height:312px;width:100%"> </div>
            </el-main>
        </el-aside>
        <el-container width="450px" direction=vertical>
            <!-- <el-header width="450px" height="'500px'">小额保险大数据可视化平台</el-header> -->
            <el-main width="450px" height="50px">
                <div id="chart1" class="chart" style="height:300px;width:100%" @dblclick="revertMap" />
            </el-main>
            <el-main width="450px" height="50px">
                <div id="chart2" class="chart" style="height:300px;width:100%"  />
            </el-main>
        </el-container>
        <el-aside width="450px">
            <el-main height="50px">
                <div id="chart3" class="chart" style="height:300px;width:100%" />
            </el-main>
            <el-main height="50px">
                <div id="chart4" class="chart" style="height:300px;width:100%" />
            </el-main>
        </el-aside>
        </el-container>
</template>
<script>
import axios from 'axios'
//import 'echarts/map/js/china.js' 
import dataJson from "@/assets/china"
import staApi from '@/api/sta'
import * as echarts from 'echarts'
import { getProvinceMapInfo } from '@/utils/map_utils'
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
            mapData:{}
            
    }
  },
  created() { //页面渲染之前执行
    this.showChart(),
    this.showChart1(),
    this.showChart2(),
    this.showChart3(),
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
                     console.log(response.data.EveryInsurance[1],response.data.EveryInsurance[2])
                     //console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart()
                })
        },
         showChart1() {
                    staApi. monthEveryMonthInjury()
                        .then(response => {
                            console.log(response)
                            this.num=response.data.EveryMonthInjury.length
                            let xData = response.data.EveryMonthInjury.map(element => element.name)
                            let yData = response.data.EveryMonthInjury.map(element => element.value)
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
            showChart2() {
                    staApi.provinceEveryInjury()
                .then(response => {
                     console.log(response)
                     console.log(response.data.EveryProvinceInjury.length)
                     this.num=response.data.EveryProvinceInjury.length
                    this.dataprovice = response.data.EveryProvinceInjury
                     let xData = response.data.EveryProvinceInjury.map(element => element.province)
                     let yData = response.data.EveryProvinceInjury.map(element => element.count)
                     console.log(xData)
                     console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart2()
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
            showChart3() {
                    staApi.avatarEveryAvatarInjury()
                        .then(response => {
                            console.log(response)
                            console.log(response.data.EveryAvatarInjury)
                            this.num=response.data.EveryAvatarInjury.length
                            let xData = response.data.EveryAvatarInjury.map(element => element.name)
                            let yData = response.data.EveryAvatarInjury.map(element => element.value)
                            console.log(xData)
                            console.log(yData)
                            this.xData=xData
                            this.yData=yData
                            //调用下面生成图表的方法，改变值
                        this.setChart3()
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
            setChart3() {
            // 基于准备好的dom，初始化echarts实例
            this.chart3 = echarts.init(document.getElementById('chart2'),'light')
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '▎各行业出险数量'
                },
                tooltip: {
                    trigger: 'axis',
                    
                },
                grid: {
                top: '20%',
                left: '3%',
                right: '6%',
                bottom: '3%',
                containLabel: true // 距离是包含坐标轴上的文字
                },
                // x轴是类目轴（离散数据）,必须通过data设置类目数据
                yAxis: {
                    type: 'category',
                    data: this.xData,
                    axisLabel: { interval: 0,
                                 rotate: 60,
                                 fontSize:10,
                                 color: "rgba(40, 37, 37, 1)",
                                 fontWeight: "bolder" }
                
                },
                // y轴是数据轴（连续数据）
                xAxis: {
                    type: 'value'
                },
                // 系列列表。每个系列通过 type 决定自己的图表类型
                series: [{
                    // 系列中的数据内容数组
                    data: this.yData,
                    // 折线图
                    type: 'bar',
                    barWidth:20,
                    label:{
                        show:true,
                        position:'right',
                        textStyle: {
                        color: 'black'
              }
                    },
                    itemStyle: {
                        barBorderRadius:[0,33,33,0],
              // 指明颜色渐变的方向
              // 指明不同百分比之下颜色的值
              color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [
                // 百分之0状态之下的颜色值
                {
                  offset: 0,
                  color: '#5052EE'
                },
                // 百分之100状态之下的颜色值
                {
                  offset: 1,
                  color: '#AB6EE5'
                }
              ])}}]}
            
            this.chart3.setOption(option)
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart3.resize();
        }
        },
            setChart2() {
            // 基于准备好的dom，初始化echarts实例
            this.chart2 = echarts.init(document.getElementById('chart1'))
            // console.log(this.chart)
            let chinadata=dataJson
            console.log(chinadata)
            echarts.registerMap("china",chinadata)
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '▎各省分布'
                },
                tooltip: {
                    triggerOn: "mousemove",   //mousemove、click
                    padding:8,
                    borderWidth:1,
                    borderColor:'#409eff',
                    backgroundColor:'rgba(255,255,255,0.7)',
                    textStyle:{
                        color:'#000000',
                        fontSize:13
                    },
                    
                    },
                    visualMap: {
                    show:true,
                    left: 5,
                    bottom: 40,
                    showLabel:true,
                    min:0,
                    max:5000,
                    inRange:{
                        color:['yellow','red']
                    },
                    calculable:true
                    },
                    geo: {
                    map: "china",
                    scaleLimit: {
                        min: 1,
                        max: 2
                    },
                    zoom: 1,
                   
                    roam: true,
                    top:'middle',
                    //bottom:'%5',
                    label: {
                        normal: {
                        //show:true,
                        fontSize: "14",
                        color: "rgba(0,0,0,0.7)"
                        }
                    },
                    itemStyle: {
                        
                        normal: {
                        shadowBlur: 50,
                        //areaColor:'#2E72BF',
                        shadowColor: 'rgba(0, 0, 0, 0.2)',
                        borderColor: "rgba(0, 0, 0, 0.2)"
                        },
                        emphasis: {
                        areaColor: "#f2d5ad",
                        shadowOffsetX: 0,
                        shadowOffsetY: 0,
                        borderWidth: 0
                        }
                    }
                    },
                    series: [
                    {
                        type: "map",
                        geoIndex: 0,
                        data:this.dataprovice
                    }
                    ]
                }
                //echart data
            this.chart2.setOption(option)
                    this.chart2.on('click', async arg =>{
                    const provinceInfo = getProvinceMapInfo(arg.name)
                    console.log(provinceInfo)
                     if (!this.mapData[provinceInfo.key]){
                    const ret = await axios.get('http://localhost:9528' + provinceInfo.path)
                    console.log(ret)
                    echarts.registerMap(provinceInfo.key, ret.data)
                     }
                const changeOption = {
                    geo: {
                        map: provinceInfo.key,
                        zoom: 1,
                   
                        roam: true,
                        top:'middle',
                            //bottom:'%5'
                    }
                    }
                 
            this.chart2.setOption(changeOption)
            })
        },
        revertMap () {
        const revertOption = {
            geo: {
            map: 'china'
            }
        }
        this.chart2.setOption(revertOption)
        window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart2.resize();
        }
        },
        setChart1() {
            // 基于准备好的dom，初始化echarts实例
            this.chart1 = echarts.init(document.getElementById('map'))
             console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                //backgroundColor: '#2c343c',
                title: {
                    text: '▎各月出险数量'
                },
                tooltip: {
                    trigger: 'axis',
                    
                },
                //系列列表。每个系列通过 type 决定自己的图表类型
               xAxis: {
                    type: 'category',
                    data: this.xData,
                    axisLabel: { interval: 0,
                                 rotate: 0,
                                 fontSize:10,
                                 //color: "rgba(40, 37, 37, 1)",
                                 //fontWeight: "bolder" 
                                 }
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

            this.chart1.setOption(option)
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

            this.chart.setOption(option)
            window.onresize = function () {//用于使chart自适应高度和宽度
    
            resizeWorldMapContainer();//重置容器高宽
            this.chart.resize();
        }
        }
         },

        
  }
</script>
