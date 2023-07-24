
-- Table: Views
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | article_id    | int     |
-- | author_id     | int     |
-- | viewer_id     | int     |
-- | view_date     | date    |
-- +---------------+---------+
-- The table may have duplicate rows (In other words, there is no primary key for this table in SQL).
-- Each row of this table indicates that some viewer viewed an article (written by some author) on some date.
-- Note that equal author_id and viewer_id indicate the same person.

select DISTINCT author_id as id from Views where author_id = viewer_id order by id