<script src="echarts.min.js"></script>
<template>
    <div class="chart-container">
     <div id="main" style="width: 600px;height:400px;"></div>
  </div>
</template>

<script>
    import echarts from 'echarts'
    export default {
        mounted(){
            var myChart = echarts.init(document.getElementById('main'));
// 绘制图表
            myChart.setOption({
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            xAxis: {
                data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
            },
            yAxis: {},
            series: [
                {
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20],
                label:{ 
                    show:true
                    }
                }
               
            ]
            });
        }
}
</script>
