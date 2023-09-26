import request from '@/utils/request'
export default {
    //1 生成统计数据
    createMakeCharts(level,gender,avatar,be_injured,injury,province,injured_scene,insurance,category) {
        return request({
            url: '/eduservice/teacher/MadeChart/'+level+'/'+gender+'/'+avatar+'/'+be_injured+'/'+injury+'/'+province+'/'+injured_scene+'/'+insurance+'/'+category,
            method: 'get'
          })
    }
}