<template>
<div class="chart-container">
      <div id="chart" class="chart" style="height:500px;width:100%" />
    </div>
</template>
<script>
import staApi from '@/api/sta/sta'
import echarts from 'echarts'
export default {
  data() {
    return {
            searchObj:{},
            btnDisabled:false,
            xData:[],
            yData:[],
            num:0,
    }
  },
  created() { //页面渲染之前执行
    this.showChart()
  },
  watch: {  //监听

  },
  methods:{
        showChart() {
            staApi.provinceEveryInjury()
                .then(response => {
                     console.log(response)
                     console.log(response.data.EveryProvinceInjury.length)
                     this.num=response.data.EveryProvinceInjury.length
                     let xData = response.data.EveryProvinceInjury.map(element => element.province)
                     let yData = response.data.EveryProvinceInjury.map(element => element.count)
                     console.log(xData)
                     console.log(yData)
                     this.xData=xData
                     this.yData=yData
                    //调用下面生成图表的方法，改变值
                   this.setChart()
                })
        },
        setChart() {
            // 基于准备好的dom，初始化echarts实例
            this.chart = echarts.init(document.getElementById('chart'))
            // console.log(this.chart)

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '数据统计'
                },
                tooltip: {
                    trigger: 'axis'
                },
                dataZoom: [{
                    show: true,
                    height: 30,
                    xAxisIndex: [
                        0
                    ],
                    bottom: 30,
                    start: 10,
                    end: 80,
                    handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                    handleSize: '110%',
                    handleStyle: {
                        color: '#d3dee5'

                    },
                    textStyle: {
                        color: '#fff'
                    },
                    borderColor: '#90979c'
                    },
                    {
                    type: 'inside',
                    show: true,
                    height: 15,
                    start: 1,
                    end: 35
                 }],
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
                    type: 'line'
                }]
            }

            this.chart.setOption(option)
        }
  }
}
</script>
