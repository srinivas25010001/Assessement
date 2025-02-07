# Stage 1: 
FROM node:18 AS builder

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .

# Stage 2: 
FROM node:18

WORKDIR /app
COPY --from=builder /app /app

CMD ["node", "index.js"]

