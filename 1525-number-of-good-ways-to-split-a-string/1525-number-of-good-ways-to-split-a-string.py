class Solution:
    def numSplits(self, s: str) -> int:
		# this is not neccessary, but speeds things up
        length = len(s)
        if length == 1:  # never splittable
            return 0
        elif length == 2:  # always splittable
            return 1
		
		# we are recording the first and last occurence of each included letter
        first = {}  # max size = 26
        last = {}  # max size = 26
		
        for index, character in enumerate(s):  # O(n)
            if character not in first:
                first[character] = index
            last[character] = index
			
		# we are concatenating the collected indices into a list and sort them
        indices = list(first.values()) + list(last.values())  # max length 26 + 26 = 52
        indices.sort()  # sorting is constant O(1) because of the length limit above
		
		# all possible splits will be in the middle of this list
        middle = len(indices)//2  # always an integer because indices has an even length
		
		# there are this many possible splits between the two 'median' numbers
        return indices[middle] - indices[middle-1]