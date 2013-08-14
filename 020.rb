def fact(n)
  (1..n).reduce(:*)
end

def sum_of_digits(n)
  n.to_s.split('').map(&:to_i).reduce(:+)
end

p sum_of_digits(fact(100))
