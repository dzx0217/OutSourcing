import request from '@/utils/request'

// 查询教授人群列表
export function listPeople(query) {
  return request({
    url: '/professors/people/list',
    method: 'get',
    params: query
  })
}

// 查询教授人群详细
export function getPeople(id) {
  return request({
    url: '/professors/people/' + id,
    method: 'get'
  })
}

// 新增教授人群
export function addPeople(data) {
  return request({
    url: '/professors/people',
    method: 'post',
    data: data
  })
}

// 修改教授人群
export function updatePeople(data) {
  return request({
    url: '/professors/people',
    method: 'put',
    data: data
  })
}

// 删除教授人群
export function delPeople(id) {
  return request({
    url: '/professors/people/' + id,
    method: 'delete'
  })
}
