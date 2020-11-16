module Lib ( 
    someFunc,
    doubleMe
) where

someFunc :: IO ()
someFunc = putStrLn "Hello Haskell!"

doubleMe :: Num a => a -> a
doubleMe x = x + x
