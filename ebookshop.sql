create database if not exists ebookshop;
    use ebookshop;
        drop table if exists books;
create table books(
    id int,
    title varchar(50),
    author varchar(50),
    price  float,
    qty int,
    primary key(id)
);

insert into books values (1001,'Java for dummies', 'Dang kim thi',11.11,11);
insert into books values (1002,'More java for dummies','code learn vn',22.22,22);
insert into books values (1003,'More java for dummies','Mohamad ali',33.33,33);
insert into books values (1004,'A cup of java','kumar',44.44,44);
insert into books values (1005,'A teaspoon of java', 'Kevin john',55.55,55);

select * from books;
select title,price from books WHERE author='code learn vn';
select title,author,price,qty from books WHERE author='code learn vn' OR price >= 30 ORDER BY price DESC