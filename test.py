import numpy as np
import pandas as pd

t1 = pd.DataFrame(np.arange(12).reshape(3, 4), index=list('abc'), columns=list('wxyz'))
print(t1)
t2 = t1.copy(deep=True)

#print("t2", t2.iloc[:, 1])
#print(type(t1))
a= t1['x'].map({1:0,5:1,9:2})
print(a)
print(t1)
# az = t1.loc["a", 'z']
# z = t1.loc[:, 'z']  # 可以切片
# print(az)
# print(type(z))


# ac = t1.loc[['a', 'c'], :]
# acc = t1.loc['b': 'c', :]
# print(ac)
# print(acc)


# iac = t1.iloc[[2,1], :]
# iacc = t1.iloc[:,1:2]
# print(iac)
# print(iacc)