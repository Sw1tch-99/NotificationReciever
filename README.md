1. Start RabbitMQ Server
2. Access RabbitMQ Web UI by opening in browser
3.  Create a Queue and add new queue
4.  Create an Exchange and add new exchange
5.  Bind Queue to Exchange
    Queues → notificationQueue
6.From exchange: notificationExchange
  Routing key: notificationRoutingKey
  add your payload
7.Use @RabbitListener to receive and AmqpTemplate to send.


