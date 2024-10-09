CREATE TABLE customer(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    birthday DATE
);

CREATE TABLE product(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE orders(
	id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    total_amount INT NOT NULL,
    customer_id INT,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE order_product (
    id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    CONSTRAINT order_key FOREIGN KEY (order_id)
        REFERENCES orders (id),
    CONSTRAINT product_key FOREIGN KEY (product_id)
        REFERENCES product (id)
);

-- insert value customer
INSERT INTO customer (id, name, email, birthday) VALUES
(1, 'John Doe', 'john.doe@example.com', '1990-05-15'),
(2, 'Jane Smith', 'jane.smith@example.com', '1985-07-20'),
(3, 'Mike Johnson', 'mike.johnson@example.com', '1992-09-10'),
(4, 'Emily Davis', 'emily.davis@example.com', '1994-03-12'),
(5, 'Robert Wilson', 'robert.wilson@example.com', '1980-11-25'),
(6, 'Sarah Miller', 'sarah.miller@example.com', '1993-01-05'),
(7, 'David Lee', 'david.lee@example.com', '1988-07-07'),
(8, 'Jessica Brown', 'jessica.brown@example.com', '1991-12-19'),
(9, 'Christopher Taylor', 'chris.taylor@example.com', '1989-02-02'),
(10, 'Megan Anderson', 'megan.anderson@example.com', '1995-06-22');
-- insert in to product
INSERT INTO product (id, name, price) VALUES
(1, 'Laptop', 1500),
(2, 'Smartphone', 800),
(3, 'Headphones', 150),
(4, 'Tablet', 600),
(5, 'Smartwatch', 250),
(6, 'Monitor', 300),
(7, 'Keyboard', 100),
(8, 'Mouse', 50),
(9, 'Camera', 1200),
(10, 'Speaker', 400);
-- insert into order
INSERT INTO orders (id, order_date, total_amount, customer_id) VALUES
(1, '2022-09-01', 2300, 1),  
(2, '2024-09-02', 800, 2),   
(3, '2022-09-03', 150, 3),  
(4, '2023-09-04', 350, 4),  
(5, '2024-09-05', 1200, 5),  
(6, '2023-09-06', 250, 6),   
(7, '2022-09-07', 1600, 7),  
(8, '2021-09-08', 150, 8), 
(9, '2024-09-09', 800, 9), 
(10, '2022-09-10', 400, 10); 
-- insert into order product
INSERT INTO order_product (id, order_id, product_id) VALUES
(1, 1, 1),  
(2, 1, 2), 
(3, 1, 3), 
(4, 2, 2),  
(5, 3, 3), 
(6, 4, 5),  
(7, 5, 9), 
(8, 6, 5),  
(9, 7, 1), 
(10, 7, 4), 
(11, 8, 3), 
(12, 9, 2), 
(13, 10, 10);

-- create index
create index idx_customer_id on customer(id);
create index idx_order_customer_id on orders(id);

-- query1: sử dụng tên cột thay vì * khi chỉ cần cột cần thiết
select * from customer;
	-- fix
select email from customer;
-- query2: sử dụng điều kiện where để lọc kết quả thay vì having nếu đươc
SELECT o.customer_id, sum(total_amount)
FROM orders o
GROUP BY o.customer_id, o.order_date
HAVING YEAR(o.order_date) = 2024;
	-- fix
SELECT o.customer_id, sum(total_amount)
FROM orders o
WHERE year(order_date) = 2024
GROUP BY o.customer_id;

-- query3: loại bỏ mệnh đề distinct không cần thiết, khiến csdl phải thực hiện thêm 1 phép so sánh
SELECT DISTINCT *
FROM customer c
JOIN orders o ON c.id = o.customer_id
WHERE o.total_amount > 1000;
	-- fix
SELECT *
FROM customer c
JOIN orders o ON c.id = o.customer_id
WHERE o.total_amount > 1000;

-- query4: viết lại sub query không cần thiết
SELECT *
FROM customer c
WHERE c.id IN (SELECT o.customer_id
				FROM orders o
                WHERE YEAR(o.order_date) = 2024
                AND o.total_amount > 1000);
	-- fix
SELECT c.*
FROM customer c, orders o
WHERE c.id = o.customer_id
AND YEAR(o.order_date) = 2024
AND o.total_amount > 1000;

-- query5 : sử dụng limit để giới hạn kết quả 
SELECT *
FROM customer;
	-- fix
SELECT * 
FROM customer LIMIT 5;

-- query6: truy vấn không có chỉ mục trên cột liên kết join
	select * from orders o join customer c on o.customer_id = c.id;
-- query7: sử dụng in khi truy vấn 1 cột đánh index

select * from customer c where c.id =2 or c.id =5;
	-- fix
    select * from customer c where c.id in (2,5);
-- query8: query với union all thay vì or
select * from customer c where c.name = "John Smith" or c.id > 5; 
select * from customer c where c.name = "John Smith"
union all
select * from customer c where c.id >5



