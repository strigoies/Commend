import request from '@/utils/request'
export default {
    //1 生成统计数据
    //2 获取统计数据
    ageEveryUserAge(insurance) {
        return request({
            url: '/eduservice/teacher/EveryUserAge/'+insurance,
            method: 'get',
            data:insurance
          })
    },
    genderEveryUserGender(insurance) {
        return request({
            url: '/eduservice/teacher/EveryUserGender/'+insurance,
            method: 'get',
            data:insurance
          })
    
    },

    avatarEveryUserAvatar(insurance) {
        return request({
            url: '/eduservice/teacher/EveryUserAvatar/'+insurance,
            method: 'get',
            data:insurance
          })
    
    },
    injuryEveryUserInjury(insurance) {
        return request({
            url: '/eduservice/teacher/EveryUserInjury/'+insurance,
            method: 'get',
            data:insurance
          })
    
    }
}