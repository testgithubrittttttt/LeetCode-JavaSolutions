class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        s_stack = []#making two stacks s and t
        t_stack = []
        for i in s:
            if len(s_stack)!=0:#checking that the length will not be equal to zero(non empty stack)
                if i=='#':
                    s_stack.pop()
                    continue
            elif i=='#':#empty stack with first character as #
                continue#so we have to skip it and go to next iteration.
            s_stack.append(i)
        for i in t:
            if len(t_stack)!=0:
                if i=='#':
                    t_stack.pop()
                    continue
            elif i=='#':
                continue
            t_stack.append(i)
        
        if s_stack == t_stack:
            return True
        else:
            return False
        