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
            var myChart = echarts.init(document.querySelector('div'));
            var myChart = echarts.init(chartDom);
            for (let i = 0; i < 5; ++i) {
            data.push(Math.round(Math.random() * 200));
            }

            option = {
            xAxis: {
                max: 'dataMax'
            },
            yAxis: {
                type: 'category',
                data: ['A', 'B', 'C', 'D', 'E'],
                inverse: true,
                animationDuration: 300,
                animationDurationUpdate: 300,
                max: 2 // only the largest 3 bars will be displayed
            },
            series: [
                {
                realtimeSort: true,
                name: 'X',
                type: 'bar',
                data: data,
                label: {
                    show: true,
                    position: 'right',
                    valueAnimation: true
                }
                }
            ],
            legend: {
                show: true
            },
            animationDuration: 0,
            animationDurationUpdate: 3000,
            animationEasing: 'linear',
            animationEasingUpdate: 'linear'
            };

            function run() {
            for (var i = 0; i < data.length; ++i) {
                if (Math.random() > 0.9) {
                data[i] += Math.round(Math.random() * 2000);
                } else {
                data[i] += Math.round(Math.random() * 200);
                }
            }
            myChart.setOption<echarts.EChartsOption>({
                series: [
                {
                    type: 'bar',
                    data
                }
                ]
            });
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
                            data: [5, 20, 36, 10, 10, 20]
                            }
                        ]
                        });
        }
}
    }
</script>
