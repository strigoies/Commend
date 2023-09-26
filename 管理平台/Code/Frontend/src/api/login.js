import request from '@/utils/request'

export function login(username, password) {
    return request({
        url: '/eduservice/user/login/' + username + "/" + password,
        method: 'post',
        data: {
            username,
            password
        }
    })
}

export function loginuser(username, password) {
    return request({
        url: '/eduservice/user/loginuser/' + username + "/" + password,
        method: 'post',
        data: {
            username,
            password
        }
    })
}

export function getInfo(token) {
    return request({
        url: '/eduservice/user/info',
        method: 'get',
        params: { token }
    })
}

export function logout() {
    return request({
        url: '/user/logout',
        method: 'post'
    })
}
export function submitLogin(userInfo) {
    return request({
        url: '/eduservice/ucenter-member/login',
        method: 'post',
        data: userInfo
    })}
export function getLoginUserInfo(formItem) {
    return request({
        url: '/eduservice/ucenter-member/getMemberInfo',
        method: 'get',
        data: formItem
        })}
