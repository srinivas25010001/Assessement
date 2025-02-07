**This task consists of docker-compose file for scaling the Node.js service and Nginx as a load balancer**

**commands to run the docker-compose file for running: docker-compose up -d --scale app=3**

**For testing the load balancing**
**npm install -g artillery
artillery quick --count 10 -n 20 http://localhost/**


