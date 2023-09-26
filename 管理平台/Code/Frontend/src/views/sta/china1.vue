<template>
  <div id="china_map" class="chart" style="height:500px;width:100%" />
</template>

<script>
import * as echarts from 'echarts'
//import 'echarts/map/js/china.js' 
import dataJson from "@/assets/china"
export default {
  data() {
    return {
      //echart 配制option  
      options: {
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
          left: 26,
          bottom: 40,
          showLabel:true,
          min:0,
          max:1000,
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
          top: 120,
          roam: true,
          label: {
            normal: {
              show:true,
              fontSize: "14",
              color: "rgba(0,0,0,0.7)"
            }
          },
          itemStyle: {
            normal: {
              //shadowBlur: 50,
              //shadowColor: 'rgba(0, 0, 0, 0.2)',
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
            //name: "突发事件",
            type: "map",
            geoIndex: 0,
            data:[]
          }
        ]
      },
      //echart data
      dataList: [
        {
          name: "南海诸岛",
          value: 100,
          eventTotal:100,
          specialImportant:10,
          import:10,
          compare:10,
          common:40,
          specail:20
        },
        {
          name: "北京",
          value: 540
        },
        {
          name: "天津",
          value: 130
        },
        {
          name: "上海",
          value: 400
        },
        {
          name: "重庆",
          value: 750
        },
        {
          name: "河北",
          value: 130
        },
        {
          name: "河南",
          value: 830
        },
        {
          name: "云南",
          value: 110
        },
        {
          name: "辽宁",
          value: 19
        },
        {
          name: "黑龙江省",
          value: 150
        },
        {
          name: "湖南",
          value: 690
        },
        {
          name: "安徽",
          value: 60
        },
        {
          name: "山东",
          value: 39
        },
        {
          name: "新疆",
          value: 4
        },
        {
          name: "江苏",
          value: 31
        },
        {
          name: "浙江",
          value: 104
        },
        {
          name: "江西",
          value: 36
        },
        {
          name: "湖北",
          value: 52
        },
        {
          name: "广西",
          value: 33
        },
        {
          name: "甘肃",
          value: 7
        },
        {
          name: "山西",
          value: 5
        },
        {
          name: "内蒙古",
          value: 778
        },
        {
          name: "陕西",
          value: 22
        },
        {
          name: "吉林",
          value: 4
        },
        {
          name: "福建",
          value: 18
        },
        {
          name: "贵州",
          value: 5
        },
        {
          name: "广东",
          value: 98
        },
        {
          name: "青海",
          value: 1
        },
        {
          name: "西藏",
          value: 0
        },
        {
          name: "四川",
          value: 44
        },
        {
          name: "宁夏",
          value: 4
        },
        {
          name: "海南",
          value: 22
        },
        {
          name: "台湾",
          value: 3
        },
        {
          name: "香港",
          value: 5
        },
        {
          name: "澳门",
          value: 555
        }
      ]
    };
  },
  methods: {
    //初始化中国地图
    initEchartMap() {
      let mapDiv = document.getElementById('china_map');
       console.log(chinadata)
            echarts.registerMap(chinadata)
      let myChart = echarts.init(mapDiv);
  
          let chinadata=dataJson
           
      myChart.setOption(this.options);
    },
    //修改echart配制
    setEchartOption(){
       this.options.series[0]['data'] = this.dataList;
    }
  },
  created() {
    this.setEchartOption();
  },
  mounted() {
      this.$nextTick(()=>{
          this.initEchartMap();
      })
    
  }
};
</script>

<style scoped>
    #china_map_box {
        height: 100%;
        position: relative;
    }
    #china_map_box #china_map{
        height: 100%;
    }
     #china_map_box .china_map_logo{
        position: absolute;
        top: 0;
        left: 0;
        width:45px;
     }
</style>
<style>
  #china_map .tooltip_style{
      line-height:1.7;
      overflow: hidden;
  }
  #china_map .tooltip_left{
      float: left;
  }
  #china_map .tooltip_right{
      float: right;
  }

</style>
// setChart2() {
//             // 基于准备好的dom，初始化echarts实例
//             this.chart = echarts.init(document.getElementById('chart1'),'light')
//             // console.log(this.chart)

//             // 指定图表的配置项和数据
//             var option = {
//                 title: {
//                     text: '▎各省分布'
//                 },
//                 tooltip: {
//                     trigger: 'axis'
//                 },
                
//                 dataZoom: [{
//                     show: true,
//                     height: 30,
//                     xAxisIndex: [
//                         0
//                     ],
//                     bottom: 30,
//                     start: 10,
//                     end: 80,
//                     handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
//                     handleSize: '110%',
//                     handleStyle: {
//                         color: '#d3dee5'

//                     },
//                     textStyle: {
//                         color: '#fff'
//                     },
//                     borderColor: '#90979c'
//                     },
//                     {
//                     type: 'inside',
//                     show: true,
//                     height: 15,
//                     start: 1,
//                     end: 35
//                  }],
//                 // x轴是类目轴（离散数据）,必须通过data设置类目数据
//                 xAxis: {
//                     type: 'category',
//                     data: this.xData
//                 },
//                 // y轴是数据轴（连续数据）
//                 yAxis: {
//                     type: 'value'
//                 },
//                 // 系列列表。每个系列通过 type 决定自己的图表类型
//                 series: [{
//                     // 系列中的数据内容数组
//                     data: this.yData,
//                     // 折线图
//                     type: 'bar'
//                 }]
//             }

//             this.chart.setOption(option)
//         },