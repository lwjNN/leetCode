package com.leetcode.dfs_bfs;

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * 示例 1:
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 注意:
 *
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/8/26 9:19
 */
public class Solution_690 {
    Map<Integer, Employee> map = new HashMap();
    public  int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return  dfs(id);
    }

    public  int dfs(Integer id){
        Employee employee = map.get(id);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates){
            ans += dfs(subid);
        }
        return ans;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        Employee e1 = new Employee(1,5, list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        Employee e2 = new Employee(2,3, list2);
        List<Integer> list3 = new ArrayList<>();
        Employee e3 = new Employee(3,4, list3);
        Employee e4 = new Employee(4,1, list3);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
//        System.out.println(getImportance(employees, 1));
    }
}
