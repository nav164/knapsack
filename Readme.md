# Task 1
## Problem Statementg
Bob is preparing to leave for his annual vacations and packing his bags for air travel. The airline allows Bob to check in only one bag with a maximum capacity of 40kg.

Bob has a list of items that he would like to take with him, however, the total weight of the items is greater than the maximum allowed capacity. Bob is clever and he comes up with a system. He weighs each of the items and also assigns a value to each of the items. Now his task is to simply pick the items with the highest value and pack his bag with it, while maintaining the allowed weight capacity. 


#### Input:
Let there be n items that Bob needs to pack, x_1 to x_n where x_i has the v_i value and weight w_i. The maximum weight he can carry is W. 

```
weights = [10, 3, 10, 2, 8, 50, 25, 2, 8, 6]
values = [30, 6, 15, 10, 24, 10, 50, 6, 20, 24]
max_capacity = 40kg
```

#### Output:
The program returns a list of items that `maximize the value` of the bag while keeping the weight under `max_capacity`.
```
items_to_pack = [10, 3, 2, 8, 2, 8, 6] = 39kg
value         = [30, 6, 10, 24, 6, 20, 24] = 120
```

Bob manages to pack his bag with his most needed items while keeping the weight in check. Bob is very happy with his effort and he decides to write a program to do this calculation.  

## Task
Your task is to write an API that accepts a list of items with their weights and values and the maximum capacity of the bag from the user, calculate the best possible list of items to pack and return a list of items to pack with the best calculated value. 

Every request to the API should be logged.  

Please consider the following:
- Testing
- Error Handling
- Logging
- Packaging (binaries/containerization)
- CI/CD 
- Git Practices
- Documentation

Please explain the limitations of your solution/approach. 


# Task 2
Once you have finished task 1, it is time for deployment. We would like you to deploy your solution on a Linux based VM in the cloud. 
In order for the solution to go into production, we must have monitoring of the infrastructure in place. 

Your task is to create 2 VMs in Azure. 
- you will deploy your solution on VM-1. You can use any tools/packaging mechanism to deploy your solution. 
- You will also implement/deploy a mechanism on VM-1 that allows you to collect system metrics e.g. CPU usage, memory usage, disk usage, system load, network utilization etc. These metrics will be forwarded to VM-2
- VM-2 will host a monitoring solution and UI to visualize the metrics. 

Please propose an appropriate solution for collecting, forwarding, storing and visualizing the metrics. 

#Deployment Credentials
```
The service principal details are as follows:
user: fab0bdde-e356-45d5-8b29-900f94229e41
password: qL?dP2=qT9qbP[-PULmykcNX6ZjTQqg4
tenant_id: 7634b95b-1c8a-4180-b7e9-c103ee2e082e
Reource Group : naveen_deployment_rg
```
You will get access to a resource group in Azure once you are ready to do the deployment. 

Good Luck.

