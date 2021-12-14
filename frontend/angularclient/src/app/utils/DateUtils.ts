export const getPrettyData = (date: Date) => {
  return new Date(date).toLocaleDateString("en-US");
};
