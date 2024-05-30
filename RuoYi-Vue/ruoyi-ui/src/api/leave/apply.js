import request from '@/utils/request'

// 查询申请列表
export function listApply(query) {
  return request({
    url: '/leave/apply/list',
    method: 'get',
    params: query
  })
}

// 查询申请详细
export function getApply(applyId) {
  return request({
    url: '/leave/apply/' + applyId,
    method: 'get'
  })
}

// 新增申请
export function addApply(data) {
  return request({
    url: '/leave/apply',
    method: 'post',
    data: data
  })
}

// 修改申请
export function updateApply(data) {
  return request({
    url: '/leave/apply',
    method: 'put',
    data: data
  })
}

// 删除申请
export function delApply(applyId) {
  return request({
    url: '/leave/apply/' + applyId,
    method: 'delete'
  })
}
