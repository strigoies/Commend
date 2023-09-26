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
    provinceEveryInjury() {
        return request({
            url: '/eduservice/teacher/EveryProvinceInjury',
            method: 'get'
          })
    
    },
    insuranceEveryInjuryInsurance() {
        return request({
            url: '/eduservice/teacher/EveryInjuryInsurance',
            method: 'get'
          })
    
    },
    avatarEveryAvatarInjuryAll() {
        return request({
            url: '/eduservice/teacher/EveryAvatarInjuryAll',
            method: 'get'
          })
    
    },
    insuranceEveryInsuranceBeInjury() {
        return request({
            url: '/eduservice/teacher/EveryInsuranceBeInjury',
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