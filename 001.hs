multiples_of_3_and_5 n =
 foldl (+) 0 [ x | x <- [1..n-1], x `mod` 3 == 0 || x `mod` 5 == 0 ]
