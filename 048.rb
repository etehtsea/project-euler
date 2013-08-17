p (1..1000).map { |n| n ** n }.reduce(:+).to_s[-10..-1]
