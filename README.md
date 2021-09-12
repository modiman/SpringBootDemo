# SpringBootDemo
 
 
## layui数据表格
###前端
```javascript
  layui.use('table', function(){
  //table 对应 html中的标签

            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#demo',  //对应id为demo的table标签                
                height: 312,
                url: 'http://localhost:8080/dataTable', //数据接口，去这个地址对应的函数查找数据
                page: true //开启分页
                ,cols: [[ //表头
                    {field: 'no', title: '序号', width:80, sort: true, fixed: 'left'},
                    {field: 'sno', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'sname', title: '用户名', width:80}
                    ,{field: 'ssex', title: '性别', width:80, sort: true}
                    ,{field: 'setting', title: '操作', width:80, sort: true}

                ]]
            });

        });

        //调用分页
```
### 后台
```java
@Controller
 public  class DataController{
    @ResponseBody
    @RequestMapping(value = "/dataTable")
//对应js中的url: 'http://localhost:8080/dataTable'，js会到这个函数取数据
    //使用Map作为返回类型是因为layui要求传入的数据必须是以下格式
/*
{
  "code": 0,
  "totalRow": {
    "score": "666"
    ,"experience": "999"
  },
  "data": [{}, {}],
  "msg": "",
  "count": 1000
}
*/
     public Map<String,Object> dataTable(@RequestParam(value = "curr",defaultValue = "1")int curr) {
        List<Student> list = studentService.getAllStudents();
        Map<String,Object> map = new   HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",list.size());
        map.put("data",list);
        System.out.println("收到请求");
        return map;
    }
}
```