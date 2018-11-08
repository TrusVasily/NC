

insert into roomtype (roomtype,roomname,price) values("LR", "Luxury",155.22);
insert into roomtype (roomtype,roomname,price) values("SR", "Student",20.00);
insert into roomtype (roomtype,roomname,price) values("CR", "Classic",70.00);

select * from room_type;

insert into employee (employeeid,firstname,lastname,address,phone) values(1,"Vasily", "Trus","BSTU","6729197");
insert into employee (employeeid,firstname,lastname,address,phone) values(2,"Dmitriy", "Bydaev","BSTU","4830453");
insert into employee (employeeid,firstname,lastname,address,phone) values(3,"Alexander", "Lomat","BSU","1111111");

select * from employee;

insert into hostel (name,address,phone,city,employeeid) values("Hilton", "Belorusskaya ylica","1234567","Minsk",1);
insert into hostel (name,address,phone,city,employeeid) values("Korona", "Gagarina street","7654321","Volozhin",2);
insert into hostel (name,address,phone,city,employeeid) values("Obschaga", "Mira street","4321567","Minsk",3);

select * from hostel;

insert into customer (firstname,lastname,address,phone,passport) values("Anatolui", "Karpov","Minsk region","3332123","MP3324123");
insert into customer (firstname,lastname,address,phone,passport) values("Vitalui", "Kyrenkov","Mogilev region","3333333","MC4534723");
insert into customer (firstname,lastname,address,phone,passport) values("Akop", "Azabyan","Erevan region","8942341","MKRT4123");

select * from customer;

insert into room (roomtype,roomdescription,hotelid) values("LR", "BAAAALDEJJJ",2);
insert into room (roomtype,roomdescription,hotelid) values("SR", "NAMANA",2);
insert into room (roomtype,roomdescription,hotelid) values("CR", "I TAK SOIDET",2);

select * from room;

insert into booking (customerid,roomid,bookingdate,datein,dateout, bill) values(1, 3,"2018-10-28","2018-10-29","2018-10-31",500.00);
insert into booking (customerid,roomid,bookingdate,datein,dateout, bill) values(2, 4,"2018-10-26","2018-10-28","2018-10-29",150.00);
insert into booking (customerid,roomid,bookingdate,datein,dateout, bill) values(3, 4,"2018-10-28","2018-10-29","2018-10-31",70.00);

select * from booking;