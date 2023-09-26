//import { login, logout, getInfo } from '@/api/user'
//import { submitLogin,getLoginUserInfo } from '@/api/loginuser'
import { submitLogin,getLoginUserInfo,logout } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'
//import { resetRouter } from '@/router'

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: []                                             // 1. 添加权限列表 roles
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {                        // 2. 添加 SET_ROLES 方法
    state.roles = roles
  }
}

const actions = {
    submitLogin({ commit }, userInfo) {
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
        submitLogin({ username: username.trim(), password: password }).then(response => {
        const { data } = response.data
        console.log({ data })
        commit('SET_TOKEN', data.token)
        setToken(data.token)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  getLoginUserInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
        getLoginUserInfo(state.token).then(response => {
        const { data } = response
        if (!data) {
          reject('Verification failed, please Login again.')
        }
        const { roles, name, avatar, introduction } = data
        if (!roles || roles.length <= 0) {
          reject('getInfo: roles must be a non-null array!')
        }
        commit('SET_ROLES', roles)                     // 3. 从用户信息中获取用户权限列表roles
        commit('SET_NAME', name)
        commit('SET_AVATAR', avatar)
        commit('SET_INTRODUCTION', introduction)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken()
        //resetRouter()
        commit('RESET_STATE')
        commit('SET_ROLES', [])                      // 4. 退出登录把角色权限列表置为空
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken()
      commit('RESET_STATE')
      commit('SET_ROLES', [])                       // 4. 退出登录把角色权限列表置为空                    
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
