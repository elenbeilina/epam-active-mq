### Active MQ

#### Task1
Implement publish/subscribe interaction between two applications. Check durable vs non-durable subscription.

![img.png](/images/img.png)

#### Task2
Implement request-reply interaction between two applications using a temporary queue in ActiveMQ.
![img_1.png](/images/img_1.png)

#### Task3
Implement subscriber scaling, i.e. create n subscribers to a topic with the same ClientID (see Virtual Topics in ActiveMQ) \
![img_2.png](/images/img_2.png)

#### Testing data
```
curl --location --request POST 'http://localhost:1362/epam/activemq/publisher/publish' \
--header 'Content-Type: text/plain' \
--data-raw 'Hello World!'
```