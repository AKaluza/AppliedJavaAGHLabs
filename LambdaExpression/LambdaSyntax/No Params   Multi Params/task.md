# Lambda Syntax — No Params & Multi Params

## Goal
Create:
1. `Supplier<String> message` returning `"Hello Lambda!"`
2. `BiFunction<Integer,Integer,Integer> sum` returning a+b

## Hints
- `Supplier<T>` has `T get()`.
- `BiFunction<T,U,R>` has `R apply(T t, U u)`.
