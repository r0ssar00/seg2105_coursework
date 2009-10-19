#if (defined(E49)&&defined(E50))||(defined(E49)&&defined(E51))||(defined(E50)&&defined(E51))
#error You must only define one question to run at a time!
#else
#ifdef E49
#warning Setting up for question E49...
#endif
#ifdef E50
#warning Setting up for question E50...
#endif
#ifdef E51
#warning Setting up for question E51
#endif
#endif
