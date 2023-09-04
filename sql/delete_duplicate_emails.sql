-- Table: Person
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | email       | varchar |
-- +-------------+---------+
-- id is the primary key (column with unique values) for this table.
-- Each row of this table contains an email. The emails will not contain uppercase letters.

delete P1 from Person P1
join Person P2 on P1.Email = P2.Email
where P1.Id > P2.Id;