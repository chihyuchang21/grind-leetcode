class Solution(object):
    def plusOne(self, digits):
        #input: [1,2,3]
        #output: [1,2,4]

        number_string = ''
        number_new = []

        #list用字串串起來
        for number in digits:
            number_string = number_string + str(number)  #123

        #字串轉int，int + 1
        number_string = str(int(number_string) + 1) #124

        #每一個位元拆開成新的list
        for number in number_string:
            #1
            #2
            #4
            print(number)
            number_new.append(int(number)) #[1,2,4]

        return number_new
 
