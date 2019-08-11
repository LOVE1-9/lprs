import request from '@/utils/request'

export function login(data) {
  return request({
    url: 'http://localhost:8080/api/login',
    method: 'post',
    // baseURL: "/api",
    data
  })
}

export function register(data) {
  return request({
    url: 'http://localhost:8080/api/register',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
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