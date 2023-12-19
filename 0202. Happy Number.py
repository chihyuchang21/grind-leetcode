#Using sets
#TBC: Using Array/ Other sets


class Solution(object):
    def isHappy(self, n):
        record = set()
        while n not in record:
            record.add(n)
            new_num = 0
            n_str = str(n)

            for i in n_str:
                new_num += int(i)**2
            if new_num==1:
                return True
            else:
                n = new_num
        return False