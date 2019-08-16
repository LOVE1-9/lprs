import request from '@/utils/request'

export function recPlate(file) {
  return request({
    url: '/api/ocrimg',
    method: 'post',
    baseURL: "/api",
    file
  })
}
