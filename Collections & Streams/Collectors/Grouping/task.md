### Grouping
GroupingBy collector is used for grouping objects by some property, and then storing the results in a Map instance.

Your task is to group the texts:

1. Fix `group` which should group texts by its length
2. Fix `multiGroup` which should group texts by its first letter and then by length.
3. Fix `groupAndConcatenate` which should concatenate strings with the same length
### output:

```
{2=[ya, xa, yf, xf, yg, xg], 3=[ybb, ydd, yee, xbb, xdd, xee], 4=[yccc, xccc, yeee, xeee]}

{x={2=[xa, xf, xg], 3=[xbb, xdd, xee], 4=[xccc, xeee]}, y={2=[ya, yf, yg], 3=[ybb, ydd, yee], 4=[yccc, yeee]}}

{2=xa-xf-xg-ya-yf-yg, 3=xbb-xdd-xee-xbb-ybb-ydd-yee-ybb, 4=xccc-xeee-yccc-yeee}


```