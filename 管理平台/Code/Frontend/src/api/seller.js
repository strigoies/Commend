import request from '@/utils/request'
export default {
    //1 生成统计数据
    createStaData(day) {
        return request({
            url: '/staservice/sta/registerCount/'+day,
            method: 'post'
          })
    },
    //2 获取统计数据
    insuranceplanEveryInsurancePlan() {
        return request({
            url: '/eduservice/teacher/EveryInsurancePlan',
            method: 'get'
          })
    
    },
    insuranceEveryInsurance() {
        return request({
            url: '/eduservice/teacher/EveryInsurance',
            method: 'get'
          })
    
    },

    avatarEveryAvatarBuyInsurance() {
        return request({
            url: '/eduservice/teacher/EveryAvatarBuyInsurance',
            method: 'get'
          })
    
    },
    monthEveryMonthInjury() {
        return request({
            url: '/eduservice/teacher/EveryMonthInjury',
            method: 'get'
          })
    
    },
    monthEveryMonthBuyInsurance() {
        return request({
            url: '/eduservice/teacher/EveryMonthBuyInsurance',
            method: 'get'
          })
    
    },

    
    avatarEveryAvatarInjury() {
        return request({
            url: '/eduservice/teacher/EveryAvatarInjury',
            method: 'get'
          })
    
    }
    //以上为数据大屏接口
    // genderEveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryGenderInjury',
    //         method: 'get'
    //       })
    
    // },
    // levelEveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryLevelInjury',
    //         method: 'get'
    //       })
    
    // },
    // careerEveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryCareerInjury',
    //         method: 'get'
    //       })
    
    // },
    // EveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryInjury',
    //         method: 'get'
    //       })
    
    // },
    // beEveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryBeInjury',
    //         method: 'get'
    //       })
    
    // },
    // ageEveryInjury() {
    //     return request({
    //         url: '/eduservice/teacher/EveryAgeInjury',
    //         method: 'get'
    //       })
    
    // }

}