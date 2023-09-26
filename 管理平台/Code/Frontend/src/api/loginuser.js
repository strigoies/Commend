import request from '@/utils/request'
export default {
    //1 生成统计数据
    createUserCommend(gender,avatar,province,sta) {
        return request({
            url: '/eduservice/teacher/UserCommend/'+gender+'/'+avatar+'/'+province+'/'+sta,
            method: 'get'
          })
    },
    getLoginUserInfo(formItem) {
        return request({
            url: '/eduservice/ucenter-member/getMemberInfo',
            method: 'get',
            data: formItem
            })},
            submitLogin(userInfo) {
                return request({
                    url: '/eduservice/ucenter-member/login',
                    method: 'post',
                    data: userInfo
                })}
}